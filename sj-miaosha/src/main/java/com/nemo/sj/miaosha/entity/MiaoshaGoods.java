package com.nemo.sj.miaosha.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("miaosha_goods")
public class MiaoshaGoods extends Model<MiaoshaGoods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("goods_id")
    private Long goodsId;
    /**
     * 秒杀价格
     */
    @TableField("miaosha_price")
    private BigDecimal miaoshaPrice;
    /**
     * 库存数量
     */
    @TableField("stock_count")
    private Integer stockCount;
    /**
     * 秒杀开始
     */
    @TableField("start_date")
    private Date startDate;
    /**
     * 秒杀结束
     */
    @TableField("end_date")
    private Date endDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
