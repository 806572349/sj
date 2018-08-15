package com.nemo.sj.miaosha.controller;

import com.nemo.sj.miaosha.common.cache.RedisService;
import com.nemo.sj.miaosha.entity.MiaoshaOrder;
import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.OrderInfo;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.result.CodeMsg;
import com.nemo.sj.miaosha.service.impl.GoodsServiceImpl;
import com.nemo.sj.miaosha.service.impl.MiaoshaOrderServiceImpl;
import com.nemo.sj.miaosha.service.impl.MiaoshaService;
import com.nemo.sj.miaosha.service.impl.MiaoshaUserServiceImpl;
import com.nemo.sj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

	@Autowired
	MiaoshaUserServiceImpl userService;
	
	@Autowired
	RedisService redisService;
	
	@Autowired
	GoodsServiceImpl goodsService;
	
	@Autowired
	MiaoshaOrderServiceImpl orderService;
	
	@Autowired
	MiaoshaService miaoshaService;
	
    @RequestMapping("/do_miaosha")
    public String list(Model model,User user,
    		@RequestParam("goodsId")long goodsId) {
    	model.addAttribute("user", user);
    	if(user == null) {
    		return "login";
    	}
    	//判断库存
    	GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
    	int stock = goods.getStockCount();
    	if(stock <= 0) {
    		model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
    		return "miaosha_fail";
    	}
    	//判断是否已经秒杀到了
    	MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
    	if(order != null) {
    		model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
    		return "miaosha_fail";
    	}
    	//减库存 下订单 写入秒杀订单
    	OrderInfo orderInfo = miaoshaService.miaosha(user, goods);
    	model.addAttribute("orderInfo", orderInfo);
    	model.addAttribute("goods", goods);
        return "order_detail";
    }
}
