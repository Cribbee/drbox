package com.lxy11.drbox.action;
import com.lxy11.drbox.Dao.GoodsRepository;
import com.lxy11.drbox.dto.GoodsDto;
import com.lxy11.drbox.po.Goods;
import com.lxy11.drbox.utils.ResultMsg;
import com.lxy11.drbox.utils.ResultStatusCode;
//import com.sun.org.apache.xpath.internal.operations.String;
import com.lxy11.drbox.utils.SpiderName;
import com.lxy11.drbox.utils.SpiderPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsRepository goodsRepository;
    @RequestMapping("getGoodsInfo")
    public Goods getGoodsInfo() {
        Goods n = new Goods();
        n.setGoodsUrl("sss");
        return n;

    }

    @Modifying
    @RequestMapping("addGoodsInfo")
    public Object addGoodsInfo(@RequestBody Goods goodsEntity)
    {
        SpiderName spiderName = new SpiderName();
        SpiderPrice spiderPrice =new SpiderPrice();
        String name = spiderName.test(goodsEntity.getGoodsUrl());
        float price = spiderPrice.test(goodsEntity.getGoodsUrl());


        goodsEntity.setCreated_at(new Date());
        goodsEntity.setGoodsName(name);
        goodsEntity.setGoodsPrice(price);
        goodsRepository.save(goodsEntity);

        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), goodsEntity);
        return resultMsg;
    }
    @RequestMapping("getGoodsInfoByUserId")
    public Object getGoodsInfoByUserId(int userId)
    {
        List<GoodsDto> goodsInfoEntity = goodsRepository.nq(userId);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), goodsInfoEntity);
        return resultMsg;
    }

    @RequestMapping("deleteGoodsInfoById")
    @Modifying
    public Object deleteGoodsInfoById(Goods goodsEntity){

        goodsRepository.delete(goodsEntity.getId());

        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), "delete from goodsId = "+goodsEntity.getId());
        return resultMsg;
    }

}
