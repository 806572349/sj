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
@TableName("miaosha_user")
public class MiaoshaUser extends Model<MiaoshaUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String head;
    @TableField("last_login_date")
    private Date lastLoginDate;
    @TableField("login_count")
    private Integer loginCount;
    private String nickname;
    private String password;
    @TableField("register_date")
    private Date registerDate;
    private String salt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
