package com.lxy11.drbox.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ChartDto {
    public ChartDto(float goodPrice, Date update_at) {
        this.goodsPrice = goodPrice;
        this.update_at = update_at;
    }

    public float goodsPrice;
    @Temporal(TemporalType.DATE)
    public Date update_at;
}
