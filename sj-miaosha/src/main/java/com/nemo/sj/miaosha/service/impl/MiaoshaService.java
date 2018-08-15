package com.nemo.sj.miaosha.service.impl;

import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.OrderInfo;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class MiaoshaService {
	
	@Autowired
	GoodsServiceImpl goodsService;
	
	@Autowired
	MiaoshaOrderServiceImpl orderService;

	@Transactional
	public OrderInfo miaosha(User user, GoodsVo goods) {
		//减库存 下订单 写入秒杀订单
		goodsService.reduceStock(goods);
		//order_info maiosha_order
		return orderService.createOrder(user, goods);
	}
	
}
