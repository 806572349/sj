package com.nemo.sj.miaosha.controller;

import com.nemo.sj.miaosha.common.cache.GoodsKey;
import com.nemo.sj.miaosha.common.cache.RedisService;
import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.result.Result;
import com.nemo.sj.miaosha.service.impl.GoodsServiceImpl;
import com.nemo.sj.miaosha.service.impl.UserServiceImpl;
import com.nemo.sj.miaosha.vo.GoodsDetailVo;
import com.nemo.sj.miaosha.vo.GoodsVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	RedisService redisService;
	@Autowired
	GoodsServiceImpl goodsService;

	@Autowired
	ThymeleafViewResolver thymeleafViewResolver;
	@Autowired
	ApplicationContext applicationContext;

    @RequestMapping("/to_list")
	@ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model, User user) {


		//取缓存
		String html = redisService.get(GoodsKey.getGoodsList, "g1", String.class);
		if(!StringUtils.isEmpty(html)) {
			return html;
		}
		model.addAttribute("user", user);
		//查询商品列表
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		model.addAttribute("goodsList", goodsList);

		// 手动渲染
		SpringWebContext ctx = new SpringWebContext(request,response,
				request.getServletContext(),request.getLocale(), model.asMap(), applicationContext );
		 html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
		if(!StringUtils.isEmpty(html)) {
			redisService.set(GoodsKey.getGoodsList, "g1", html);
		}
		return html;
    }
	@RequestMapping("/to_detail/{goodsId}")
	public String detail(HttpServletRequest request, HttpServletResponse response,Model model,MiaoshaUser user,
						 @PathVariable("goodsId")long goodsId) {
		model.addAttribute("user", user);
		//取缓存
		String html = redisService.get(GoodsKey.getGoodsDetail, ""+goodsId, String.class);
		if(!StringUtils.isEmpty(html)) {
			return html;
		}
		// TODO: 2018/8/14 snowflake   id 算法
		//手动渲染
		 html = redisService.get(GoodsKey.getGoodsDetail, ""+goodsId, String.class);
		if(!StringUtils.isEmpty(html)) {
			return html;
		}
		//手动渲染
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		model.addAttribute("goods", goods);

		long startAt = goods.getStartDate().getTime();
		long endAt = goods.getEndDate().getTime();
		long now = System.currentTimeMillis();

		int miaoshaStatus = 0;
		int remainSeconds = 0;
		if(now < startAt ) {//秒杀还没开始，倒计时
			miaoshaStatus = 0;
			remainSeconds = (int)((startAt - now )/1000);
		}else  if(now > endAt){//秒杀已经结束
			miaoshaStatus = 2;
			remainSeconds = -1;
		}else {//秒杀进行中
			miaoshaStatus = 1;
			remainSeconds = 0;
		}
		model.addAttribute("miaoshaStatus", miaoshaStatus);
		model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
		//手动渲染
//		SpringWebContext ctx = new SpringWebContext(request,response,
//				request.getServletContext(),request.getLocale(), model.asMap(), applicationContext );
//		html = thymeleafViewResolver.getTemplateEngine().process("goods_detail", ctx);
//		if(!StringUtils.isEmpty(html)) {
//			redisService.set(GoodsKey.getGoodsDetail, ""+goodsId, html);
//		}
//		return html;
	}



    
}
