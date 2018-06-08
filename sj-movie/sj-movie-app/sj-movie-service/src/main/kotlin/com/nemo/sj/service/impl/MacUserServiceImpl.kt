package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacUser;
import com.nemo.sj.mapper.MacUserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacUserService
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
open class MacUserServiceImpl : ServiceImpl<MacUserMapper, MacUser>(), IMacUserService {

}
