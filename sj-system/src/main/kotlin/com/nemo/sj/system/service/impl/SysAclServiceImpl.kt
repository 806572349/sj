package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysAcl;
import com.nemo.sj.system.mapper.SysAclMapper;
import com.nemo.sj.system.service.ISysAclService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.dto.AclDto
import com.nemo.sj.dto.SysAclTree
import com.nemo.sj.system.entity.SysRoleAcl
import com.nemo.sj.system.service.ISysRoleAclService
import com.nemo.sj.system.service.ISysRoleService
import com.nemo.sj.system.service.ISysRoleUserService
import com.nemo.sj.util.TreeUtil
import org.apache.coyote.http11.Constants.a
import org.bouncycastle.crypto.tls.CipherType.stream
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
import java.util.*
import java.util.stream.Collectors
import javax.annotation.Resource
import kotlin.collections.ArrayList
import kotlin.streams.toList

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

    @Resource
    lateinit var sysAclService: ISysAclService

    @Autowired
    lateinit var iSysRoleService: ISysRoleService

    @Autowired
    lateinit var iSysRoleAclService: ISysRoleAclService

    @Autowired
    lateinit var iSysRoleUserService: ISysRoleUserService

    /**
     *  根据角色名 查询模块列表
     */
    override fun findAclByRoleName(roleName: String): List<SysAcl> {
        //获取角色信息
        val sysRole = iSysRoleService.findByRoleName(roleName)
        // 获取该角色下的模块ID
        val roleAclList = iSysRoleAclService.findAclByRoleId(sysRole.id)
        val collect = roleAclList.stream().map { a ->

            val sysAcl = sysAclService.selectById(a.aclId)
            sysAcl
        }.collect(Collectors.toList())

        return collect
    }

    /**
     * 通过用户id  查询模块
     * @param uid  用户id
     */
    override fun findByAclByUserId(uid: Int): List<SysAclTree> {
        //查询用户角色列表
        val roleList = iSysRoleUserService.findRoleListByUserId(uid)
        val collect = roleList.stream()
                .map { role ->
                    // 查询角色模块映射关系
                    val aclRoles = iSysRoleAclService.findAclByRoleId(role.id)
                    // 查询模块列表
                    val aclList = aclRoles.stream().map { b ->
                        val sysAcl = sysAclService.selectById(b.aclId)
                        sysAcl
                    }.filter { t -> t != null }.collect(Collectors.toList())
                    aclList
                }.filter { rt -> rt != null }
                .filter { k -> k.size != 0 }
                .collect(Collectors.toList())
        var aclList = ArrayList<SysAcl>()
        // 增加模块
        collect.forEach { a -> aclList.addAll(a) }
        aclList.sortWith(kotlin.Comparator { o1, o2 -> o1.seq!!.compareTo(o2.seq!!) })

        // 转化为模块dto
        val dtoList = aclList.stream().map { q ->
            var dto = AclDto()
            BeanUtils.copyProperties(q, dto)
            dto
        }
                // 过滤出菜单状态不为0
                .filter { k -> k.status != 0 }
                .collect(Collectors.toList())

        var treeList = ArrayList<SysAclTree>()
        // 获取模块树
        dtoList.forEach { y ->
            val sysAclTree = SysAclTree()
            BeanUtils.copyProperties(y, sysAclTree)
            //多角色模块重复问题
            if (!treeList.contains(sysAclTree)) {
                treeList.add(sysAclTree)
            }
        }
        // 模块排序
        treeList.sortWith(kotlin.Comparator { o1, o2 -> o1.seq!!.compareTo(o2.seq!!) })
        //root节点id 为-1
        return TreeUtil.bulid(treeList, -1)
    }


}




