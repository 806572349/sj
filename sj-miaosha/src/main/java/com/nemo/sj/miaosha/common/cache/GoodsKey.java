package com.nemo.sj.miaosha.common.cache;

/**
 * create by Nemo
 * 2018/8/15  10:06
 */
public class GoodsKey  extends BasePrefix{
    public GoodsKey(String prefix) {
        super(prefix);
    }

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(600, "gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(600, "gd");
}
