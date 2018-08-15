package com.nemo.sj.miaosha.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author nemo
 * @since 2018-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;
    /**
     * 商品标题
     */
    @TableField("goods_title")
    private String goodsTitle;
    /**
     * 商品图片
     */
    @TableField("goods_img")
    private String goodsImg;
    /**
     * 商品的详情介绍
     */
    @TableField("goods_detail")
    private String goodsDetail;
    /**
     * 价格
     */
    @TableField("goods_price")
    private BigDecimal goodsPrice;
    /**
     * 库存  -1 无限
     */
    @TableField("goods_stook")
    private Integer goodsStook;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
