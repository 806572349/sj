package com.nemo.sj.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.mapper.Wrapper
import com.nemo.sj.system.entity.SysUser;
import com.nemo.sj.system.mapper.SysUserMapper;
import com.nemo.sj.system.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.exception.OptException
import com.nemo.sj.system.common.util.MD5Util
import com.nemo.sj.system.dao.SysUserDao
import org.apache.commons.lang3.StringUtils
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
open class SysUserServiceImpl : ServiceImpl<SysUserMapper, SysUser>(), ISysUserService {


    @Autowired
    lateinit var userDao: SysUserDao;

    /**
     * 登陆
     */
    override fun  login(user: SysUser):SysUser?{
        val password = user.password
        user.password=null
        //查询用户信息
        val sysUser = userDao.queryone(user)
        if (sysUser==null){
            throw  OptException("未找到用户名");
        }
        if (!sysUser.password.equals(MD5Util.md5Digest(password),true)){
            throw  OptException("密码错误")
        }
       return  sysUser;
    }

    /**
     * 通过部门id  用户列表
     * @param depId 部门id
     */
    override fun  findByDepIdList(depId:Int):List<SysUser>{
        var user=SysUser().apply { deptId=depId }
        return userDao.queryListByDepId(user);
    }
}
