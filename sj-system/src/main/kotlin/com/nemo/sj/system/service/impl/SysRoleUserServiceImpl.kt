package com.nemo.sj.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.sj.system.entity.SysRoleUser;
import com.nemo.sj.system.mapper.SysRoleUserMapper;
import com.nemo.sj.system.service.ISysRoleUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.system.entity.SysRole
import com.nemo.sj.system.service.ISysRoleService
import org.apache.coyote.http11.Constants.a
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import java.util.stream.Collector
import java.util.stream.Collectors

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

    /**
     * 通过用户id 查询角色列表
     */
    @Autowired
    lateinit var  iysRoleService: ISysRoleService

    /**
     * 通过用户id 查询角色列表
     */
    override fun findRoleListByUserId(userId:Int?):List<SysRole>{
        val wrapper = Condition.wrapper<SysRoleUser>()
        wrapper.eq("user_id",userId)
        var userRolelist = this.selectList(wrapper)
        val roleList = userRolelist.stream().map { a ->
               val role = iysRoleService.selectById(a.roleId)
                role

        }.collect(Collectors.toList())
        return  roleList
    }
}
