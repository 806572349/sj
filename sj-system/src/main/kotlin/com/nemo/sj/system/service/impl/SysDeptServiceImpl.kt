package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysDept;
import com.nemo.sj.system.mapper.SysDeptMapper;
import com.nemo.sj.system.service.ISysDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.dto.DeptTree
import com.nemo.sj.dto.TreeNode
import com.nemo.sj.system.dao.SysDeptDao
import com.nemo.sj.util.TreeUtil
import org.bouncycastle.asn1.x500.style.RFC4519Style.c
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service;
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
open class SysDeptServiceImpl : ServiceImpl<SysDeptMapper, SysDept>(), ISysDeptService {

    @Autowired
    lateinit var  sysDeptDao: SysDeptDao

    /**
     * 查询部门树
     */
    override fun  findByDeptTree(dept: SysDept,root:Int) :List<DeptTree>{
        // 1.获取部门列表
        val deptList = sysDeptDao.findByDeptList(dept)
        // 2.获取dept 树
        val deptData = deptList.stream()
                .map { dept ->
                    var deptTree= DeptTree()
                    BeanUtils.copyProperties(dept,deptTree)
                    deptTree
                }
                .collect(Collectors.toList())
        // 3 建立树结构
        val treeDept = TreeUtil.bulid(deptData, root)
        return treeDept
    }


    override fun  findList(dept: SysDept) :List<SysDept>{
        // 1.获取部门列表
        return sysDeptDao.findByDeptList(dept)

    }
}
