package com.lxy11.drbox.po;

import javax.persistence.*;
import java.util.Date;


    @Entity
    @Table(name = "chart_info")
    public class Price {

        @Id
        @GeneratedValue
        private int id;
        private int userId;
        private int goodsId;
        private String goodsUrl;
        private float goodsPrice;
        private boolean goodsStatus;
        @Temporal(TemporalType.DATE)
        private Date update_at;



        public Price() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsUrl() {
            return goodsUrl;
        }

        public void setGoodsUrl(String goodsUrl) {
            this.goodsUrl = goodsUrl;
        }

        public float getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(float goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public boolean isGoodsStatus() {
            return goodsStatus;
        }

        public void setGoodsStatus(boolean goodsStatus) {
            this.goodsStatus = goodsStatus;
        }

        public Date getUpdate_at() {
            return update_at;
        }

        public void setUpdate_at(Date update_at) {
            this.update_at = update_at;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "id=" + id +
                    ", userId=" + userId +
                    ", goodsId=" + goodsId +
                    ", goodsUrl='" + goodsUrl + '\'' +
                    ", goodsPrice='" + goodsPrice + '\'' +
                    ", goodsStatus=" + goodsStatus +
                    ", update_at=" + update_at +
                    '}';
        }
    }
