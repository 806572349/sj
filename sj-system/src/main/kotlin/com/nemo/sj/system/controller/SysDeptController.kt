package com.nemo.sj.system.controller;


import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.sj.dto.DeptTree
import com.nemo.sj.dto.TreeNode
import com.nemo.sj.exception.OptException
import com.nemo.sj.system.entity.SysDept
import com.nemo.sj.system.service.ISysDeptService
import org.apache.coyote.http11.Constants.a
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@RestController
@RequestMapping("/system/sysDept")
class SysDeptController {

    @Autowired
    lateinit var iSysDeptService: ISysDeptService

    @GetMapping("/list/tree")
    fun findByDeptTree(dept: SysDept): List<DeptTree> {
        return iSysDeptService.findByDeptTree(dept, 0)
    }

    @GetMapping("/list")
    fun findList(dept: SysDept): List<SysDept> {
        return iSysDeptService.findList(dept)
    }

    /**
     * 增加一个或者更新
     */
    @PostMapping("/soudept")
    fun saveOrUpdateDept(sysDept: SysDept): SysDept {
        sysDept.operateTime = Date()
        if (sysDept.id != null) {

            val updateSysDept = iSysDeptService.selectById(sysDept.id)
            if (updateSysDept.id!!.equals(sysDept.parentId)){
                throw OptException("根树父节点不能是自己")
            }
            // 查询父节点下面的所有子节点
            val deptTree = iSysDeptService.findByDeptTree(SysDept(), updateSysDept.id!!)
            // 查询含有子树的根树
            if (deptTree.size>0){
                // 遍历根树下面所有的子树
                var sonTree = ArrayList<TreeNode>()
                getSonTree(deptTree.get(0), sonTree)
                sonTree.forEach { a ->
                    if (sysDept.parentId!!.equals(a.id)) {
                        throw OptException("父节点不能修改到子节点下面")
                    }
                }
            }
        }
        iSysDeptService.insertOrUpdate(sysDept)
        return sysDept
    }

    /**
     * 遍历根树下面所有的子树
     */
    fun getSonTree(rootNode: TreeNode, sonTree: ArrayList<TreeNode>) {

        if (rootNode.children.size > 0) {
            rootNode.children.forEach { a ->
                sonTree.add(a)
                getSonTree(a, sonTree)
            }
        }
    }

}
