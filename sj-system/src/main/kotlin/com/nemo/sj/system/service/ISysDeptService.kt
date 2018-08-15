package com.nemo.sj.system.service;

import com.nemo.sj.system.entity.SysDept;
import com.baomidou.mybatisplus.service.IService;
import com.nemo.sj.dto.DeptTree

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
interface ISysDeptService : IService<SysDept> {
    /**
     * 查询部门树
     */
    fun findByDeptTree(dept:SysDept,root:Int): List<DeptTree>
    fun findList(dept: SysDept): List<SysDept>
}
