package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacUserCard;
import com.nemo.sj.mapper.MacUserCardMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacUserCardService
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
@Service
open class MacUserCardServiceImpl : ServiceImpl<MacUserCardMapper, MacUserCard>(), IMacUserCardService {

}
