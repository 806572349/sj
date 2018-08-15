package com.nemo.sj.miaosha.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nemo.sj.miaosha.entity.MiaoshaOrder;
import com.nemo.sj.miaosha.entity.MiaoshaUser;
import com.nemo.sj.miaosha.entity.OrderInfo;
import com.nemo.sj.miaosha.entity.User;
import com.nemo.sj.miaosha.mapper.MiaoshaOrderMapper;
import com.nemo.sj.miaosha.mapper.OrderInfoMapper;
import com.nemo.sj.miaosha.service.IMiaoshaOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-08-14
 */
@Service
public class MiaoshaOrderServiceImpl extends ServiceImpl<MiaoshaOrderMapper, MiaoshaOrder> implements IMiaoshaOrderService {
    @Resource
    MiaoshaOrderMapper miaoshaOrderMapper;

    @Autowired
    OrderInfoServiceImpl orderInfoService;



    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
        EntityWrapper<MiaoshaOrder> wrapper = Condition.<MiaoshaOrder>wrapper();
        wrapper.eq("user_id",userId);
        wrapper.eq("goods_id",goodsId);
        List<MiaoshaOrder> miaoshaOrders = this.selectList(wrapper);
        return miaoshaOrders.size()>0?miaoshaOrders.get(0):null;
    }

    @Transactional
    public OrderInfo createOrder(User user, GoodsVo goods) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(user.getId());
         orderInfoService.insert(orderInfo);
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setOrderId(orderInfo.getId());
        miaoshaOrder.setUserId(user.getId());
        this.insert(miaoshaOrder);
        return orderInfo;
    }
}
