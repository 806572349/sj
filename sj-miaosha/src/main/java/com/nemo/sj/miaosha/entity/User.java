package com.nemo.sj.miaosha.entity;

import java.util.Date;
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
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id  手机号码
     */
    private Long id;
    private String nickname;
    /**
     * 两次md5 加盐
     */
    private String password;
    private String salt;
    private String head;
    @TableField("register_date")
    private Date registerDate;
    @TableField("last_login_date")
    private Date lastLoginDate;
    /**
     * 登陆次数
     */
    @TableField("login_count")
    private Integer loginCount;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
