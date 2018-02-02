package com.lxy11.drbox.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class GoodsDto {
    public GoodsDto(int id,float goodPrice,int goodsType,String goodsName,String goodsUrl, Date created_at) {
        this.id = id;
        this.goodsType = goodsType;
        this.goodsName =goodsName;
        this.goodsUrl = goodsUrl;
        this.goodsPrice = goodPrice;
        this.created_at = created_at;
    }

    public int id;
    public String goodsName;
    public int goodsType;
    public String goodsUrl;
    public float goodsPrice;
    @Temporal(TemporalType.DATE)
    public Date created_at;
}