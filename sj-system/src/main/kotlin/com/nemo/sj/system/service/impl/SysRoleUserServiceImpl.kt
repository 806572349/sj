package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysRoleUser;
import com.nemo.sj.system.mapper.SysRoleUserMapper;
import com.nemo.sj.system.service.ISysRoleUserService;
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
open class SysRoleUserServiceImpl : ServiceImpl<SysRoleUserMapper, SysRoleUser>(), ISysRoleUserService {

}
