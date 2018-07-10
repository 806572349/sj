package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysAcl;
import com.nemo.sj.system.mapper.SysAclMapper;
import com.nemo.sj.system.service.ISysAclService;
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
open class SysAclServiceImpl : ServiceImpl<SysAclMapper, SysAcl>(), ISysAclService {

}
