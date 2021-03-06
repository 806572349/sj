package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacManager;
import com.nemo.sj.mapper.MacManagerMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacManagerService
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
open class MacManagerServiceImpl : ServiceImpl<MacManagerMapper, MacManager>(), IMacManagerService {

}
