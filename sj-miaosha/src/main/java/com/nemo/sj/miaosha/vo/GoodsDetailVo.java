package com.nemo.sj.miaosha.vo;

import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.User;

/**
 * create by Nemo
 * 2018/8/15  12:18
 */
public class GoodsDetailVo {

    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsVo goods ;
    private User user;
    public int getMiaoshaStatus() {
        return miaoshaStatus;
    }
    public void setMiaoshaStatus(int miaoshaStatus) {
        this.miaoshaStatus = miaoshaStatus;
    }
    public int getRemainSeconds() {
        return remainSeconds;
    }
    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }
    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
