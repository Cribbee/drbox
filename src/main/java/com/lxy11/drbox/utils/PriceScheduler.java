package com.lxy11.drbox.utils;

import com.lxy11.drbox.Dao.ChartRepository;
import com.lxy11.drbox.Dao.GoodsRepository;
import com.lxy11.drbox.Dao.UserInfoRepository;
import com.lxy11.drbox.po.Goods;
import com.lxy11.drbox.po.Price;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PriceScheduler {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PriceScheduler.class);
    @Autowired
    private ChartRepository chartRepository;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    private EmailServiceImpl emailService;

    @Autowired
    private JavaMailSender mailSender;
    @Scheduled(cron = "0 0 0 1/1 * ?")//从每月的一号开始，每天的00:00执行一次
    public void priceInsert(){


        EmailServiceImpl emailService = new EmailServiceImpl();
        SpiderPrice spiderPrice =new SpiderPrice();
        List<Goods> goodsInfo =goodsRepository.findAll();
        for ( Goods item: goodsInfo)
        {


            Price chart = new Price();//特别注意，如果拿到外面实例化，save方法只能对第一个对象进行保存

            chart.setUpdate_at(new Date());
            chart.setGoodsId(item.getId());
            chart.setGoodsUrl(item.getGoodsUrl());
            chart.setGoodsStatus(item.isGoodsStatus());
            chart.setUserId(item.getUserId());

            float price = spiderPrice.test(item.getGoodsUrl());
            chart.setGoodsPrice(price);

            if (0.95*item.getGoodsPrice() >=price ){
                String titel = "心愿盒降价提醒";
                String content = "您所关注的商品: "+item.getGoodsName()+" 已经降价幅度超过5%，请知悉!欲直接购买请点击："+item.getGoodsUrl();


                emailService.sendSimpleMail(userInfoRepository.findOne(item.getUserId()).getEmail().toString(), titel, content);
                logger.info("邮件成功发送至用户ID为:{} ",item.getUserId());
            }
            else {
                logger.info("该商品未降价 商品名称：{} ",item.getGoodsName());
            }

            chartRepository.save(chart);


            System.out.println("成功更新一次价格记录");

        }


    }
}

