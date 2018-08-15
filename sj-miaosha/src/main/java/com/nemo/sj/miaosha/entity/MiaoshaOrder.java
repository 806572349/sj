package com.nemo.sj.miaosha.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("miaosha_order")
public class MiaoshaOrder extends Model<MiaoshaOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("goods_id")
    private Long goodsId;
    @TableField("order_id")
    private Long orderId;
    @TableField("user_id")
    private Long userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
