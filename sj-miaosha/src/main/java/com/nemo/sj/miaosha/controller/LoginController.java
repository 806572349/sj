package com.nemo.sj.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.nemo.sj.miaosha.common.cache.RedisService;
import com.nemo.sj.miaosha.result.Result;
import com.nemo.sj.miaosha.service.impl.UserServiceImpl;
import com.nemo.sj.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    UserServiceImpl userService;
	
	@Autowired
    RedisService redisService;
	
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	//登录
        String login = userService.login(response, loginVo);
        return Result.success(login);
    }
}
