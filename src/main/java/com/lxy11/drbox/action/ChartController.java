package com.lxy11.drbox.action;

import com.lxy11.drbox.Dao.ChartRepository;
import com.lxy11.drbox.dto.ChartDto;
import com.lxy11.drbox.po.Price;
import com.lxy11.drbox.utils.ResultMsg;
import com.lxy11.drbox.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chart")
public class ChartController {
    @Autowired
    private ChartRepository chartRepositoy;

    @Modifying
    @RequestMapping("getChartInfoById")
    public Object getChart(int id)
    {
        Price chartEntity = chartRepositoy.findChartInfoById(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), chartEntity);
        return resultMsg;
    }
    @RequestMapping("getChatInfoByGoodsId")
    public Object getChatInfoByGoodsId(int goods_id)
    {
        List<ChartDto> chartInfoEntity = chartRepositoy.nativeQuery(goods_id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(), ResultStatusCode.OK.getErrmsg(), chartInfoEntity);
        return resultMsg;
    }


}