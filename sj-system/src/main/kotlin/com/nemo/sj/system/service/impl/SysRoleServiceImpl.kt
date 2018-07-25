package com.nemo.sj.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.sj.system.entity.SysRole;
import com.nemo.sj.system.mapper.SysRoleMapper;
import com.nemo.sj.system.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.system.dao.SysRoleDao
import org.springframework.beans.factory.annotation.Autowired
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
open class SysRoleServiceImpl : ServiceImpl<SysRoleMapper, SysRole>(), ISysRoleService {

    @Autowired
    lateinit var sysRoleDao: SysRoleDao

    /**
     * 根据角色名称查找 角色信息
     */
    override fun findByRoleName(roleName:String):SysRole{
        val  sysRole=SysRole().apply { name=roleName }
        return sysRoleDao.findOne(sysRole)
    }
}
