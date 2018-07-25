package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysRoleAcl;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysRoleAclService : IService<SysRoleAcl> {
    fun findAclByRoleId(rid: Int?): List<SysRoleAcl>
}
