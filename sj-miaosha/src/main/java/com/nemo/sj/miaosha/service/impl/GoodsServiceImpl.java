package com.nemo.sj.miaosha.service.impl;

import com.nemo.sj.miaosha.entity.Goods;
import com.nemo.sj.miaosha.entity.MiaoshaGoods;
import com.nemo.sj.miaosha.mapper.GoodsMapper;
import com.nemo.sj.miaosha.service.IGoodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.miaosha.vo.GoodsVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    GoodsMapper goodsMapper;


    public List<GoodsVo> listGoodsVo(){
        return goodsMapper.listGoodsVo();
    }
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsMapper.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsMapper.reduceStock(g);
    }

}
