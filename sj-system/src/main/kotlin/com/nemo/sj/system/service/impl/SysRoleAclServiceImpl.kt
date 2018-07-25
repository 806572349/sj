package com.nemo.sj.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.sj.system.entity.SysRoleAcl;
import com.nemo.sj.system.mapper.SysRoleAclMapper;
import com.nemo.sj.system.service.ISysRoleAclService;
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
open class SysRoleAclServiceImpl : ServiceImpl<SysRoleAclMapper, SysRoleAcl>(), ISysRoleAclService {

    /**
     * 根据角色id 查询模块信息
     */
   override fun  findAclByRoleId(rid:Int?):List<SysRoleAcl>{
        val entityWrapper = Condition.wrapper<SysRoleAcl>()
        entityWrapper.eq("role_id",rid)
        return this.selectList(entityWrapper)
    }
}
