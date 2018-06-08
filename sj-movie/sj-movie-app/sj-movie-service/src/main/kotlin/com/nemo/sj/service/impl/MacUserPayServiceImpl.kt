package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacUserPay;
import com.nemo.sj.mapper.MacUserPayMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacUserPayService
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
open class MacUserPayServiceImpl : ServiceImpl<MacUserPayMapper, MacUserPay>(), IMacUserPayService {

}
