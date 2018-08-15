package com.nemo.sj.miaosha.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("order_info")
public class OrderInfo extends Model<OrderInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("create_date")
    private Date createDate;
    @TableField("delivery_addr_id")
    private Long deliveryAddrId;
    @TableField("goods_count")
    private Integer goodsCount;
    @TableField("goods_id")
    private Long goodsId;
    @TableField("goods_name")
    private String goodsName;
    @TableField("goods_price")
    private Double goodsPrice;
    @TableField("order_channel")
    private Integer orderChannel;
    @TableField("pay_date")
    private Date payDate;
    /**
     * 0未支付 1 已支付 2已发货 3已收货4 已退款5 已完成
     */
    private Integer status;
    @TableField("user_id")
    private Long userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
