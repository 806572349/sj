package com.nemo.sj.miaosha.controller;

import com.nemo.sj.miaosha.common.cache.RedisService;
import com.nemo.sj.miaosha.common.cache.UserKey;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.mq.MQSender;
import com.nemo.sj.miaosha.result.CodeMsg;
import com.nemo.sj.miaosha.result.Result;
import com.nemo.sj.miaosha.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by Nemo
 * 2018/8/13  10:52
 */
@Controller
public class DemoController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private MQSender mqSender;

    @ResponseBody
    @GetMapping("success")
    public  Result test(){
        return Result.success(CodeMsg.SUCCESS);
    }

    @GetMapping("a")
    public  String test2(Model model){
        model.addAttribute("name","sj");
        return "hello";
    }
    @ResponseBody
    @GetMapping("/b")
    public User findbyId(Integer id){
       return iUserService.selectById(id);
    }

    @ResponseBody
    @GetMapping("/c")
    public  String set(){
        User user = iUserService.selectById(1);
        redisService.set(UserKey.getById,"1",user);
        return "sucess";
    }

    @ResponseBody
    @GetMapping("/g")
    public  User get(){
      return   redisService.get(UserKey.getById,"1",User.class);
    }

//    @GetMapping
//    public  void tet(){
//        User user = new User();
//        user.setId(1L);
//        mqSender.send(user);
//    }

    @GetMapping("/ss")
    public  void ttopic(){
        User user = new User();
        user.setId(1L);
        mqSender.sendTopic(user);
    }
}
