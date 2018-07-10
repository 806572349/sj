package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysUser;
import com.nemo.sj.system.mapper.SysUserMapper;
import com.nemo.sj.system.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@Service
open class SysUserServiceImpl : ServiceImpl<SysUserMapper, SysUser>(), ISysUserService {

}
