package com.nemo.sj.system.dao

import com.baomidou.mybatisplus.mapper.Condition
import com.nemo.mp.base.BaseDao
import com.nemo.sj.system.entity.SysDept
import com.nemo.sj.system.mapper.SysDeptMapper
import org.apache.coyote.http11.Constants.a
import org.springframework.stereotype.Repository
import java.util.*
import javax.annotation.Resource

/**
 *  create by Nemo
 *  2018/8/4  18:23
 */
@Repository
class SysDeptDao :BaseDao() {

    @Resource
     lateinit var  deptMapper:SysDeptMapper

    /**
     * 查询部门整个列表
     */
    fun  findByDeptList(dept:SysDept?):List<SysDept>{
        val entityWrapper = Condition.wrapper<SysDept>()
        if (dept!!.parentId!=null) entityWrapper.eq("parent_id",dept!!.parentId)
        if (dept!!.id!=null) entityWrapper.eq("id",dept!!.id)
        entityWrapper.orderDesc(Arrays.asList("seq"));

       return deptMapper.selectList(entityWrapper)
    }
}