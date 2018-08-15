package com.nemo.sj.miaosha.service.impl;

import com.nemo.sj.miaosha.common.cache.MiaoshaUserKey;
import com.nemo.sj.miaosha.common.cache.RedisService;
import com.nemo.sj.miaosha.common.cache.UserKey;
import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.exception.GlobalException;
import com.nemo.sj.miaosha.mapper.UserMapper;
import com.nemo.sj.miaosha.result.CodeMsg;
import com.nemo.sj.miaosha.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.miaosha.util.MD5Util;
import com.nemo.sj.miaosha.util.UUIDUtil;
import com.nemo.sj.miaosha.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-08-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    public static final String COOKI_NAME_TOKEN = "token";
    @Autowired
    RedisService redisService;

    public User getById(long id) {
        //取缓存
        User user = redisService.get(UserKey.getById, "" + id, User.class);
        if (user!=null)return null;
        //取数据
        user= this.selectById(id);
        if (user!=null) redisService.set(UserKey.getById, "" + id, user);
        return user;
    }

    // http://blog.csdn.net/tTU1EvLDeLFq5btqiK/article/details/78693323
    public boolean updatePassword(String token, long id, String formPass) {
        //取user
        User user = getById(id);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
        this.insertOrUpdate(toBeUpdate);
        //处理缓存
        redisService.delete(UserKey.getById, ""+id);
        user.setPassword(toBeUpdate.getPassword());
        redisService.set(MiaoshaUserKey.token, token, user);
        return true;
    }


    public User getByToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(MiaoshaUserKey.token, token, User.class);
        //延长有效期
        if(user != null) {
            addCookie(response, token, user);
        }
        return user;
    }


    public String login(HttpServletResponse response, LoginVo loginVo) {
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        User user = getById(Long.parseLong(mobile));
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token	 = UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
