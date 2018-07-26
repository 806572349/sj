package com.nemo.sj.system.service.impl;

import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.mapper.Wrapper
import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.system.entity.SysUser;
import com.nemo.sj.system.mapper.SysUserMapper;
import com.nemo.sj.system.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.common.JsonData
import com.nemo.sj.constant.SecurityConstants
import com.nemo.sj.exception.OptException
import com.nemo.sj.system.common.util.MD5Util
import com.nemo.sj.system.config.RedisRepo
import com.nemo.sj.system.dao.SysUserDao
import com.nemo.sj.system.service.ISysDeptService
import com.nemo.sj.system.service.ISysRoleService
import com.nemo.sj.system.service.ISysRoleUserService
import com.nemo.sj.system.vo.SysUserDto
import org.apache.commons.lang3.StringUtils
import org.apache.coyote.http11.Constants.a
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

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

    @Autowired
    lateinit var redisRepo: RedisRepo

    @Autowired
    lateinit var sysDeptServiceImpl: ISysDeptService

    @Autowired
    lateinit var iSysRoleUserService: ISysRoleUserService
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

    /**
     * 保存图片
     */
    override fun saveImageCode(randomStr:String,text:String){
        redisRepo.save(SecurityConstants.DEFAULT_CODE_KEY+randomStr,text,10,TimeUnit.MINUTES);
    }

    /**
     * 保存hashCode
     */
    override fun  saveHashCode():JsonData{
        val rondomMD5Str = MD5Util.RondomMD5Str()
        redisRepo.save(SecurityConstants.DEFAULT_CODE_KEY+rondomMD5Str,rondomMD5Str,10,TimeUnit.MINUTES)
        return JsonData.success(rondomMD5Str,"hashCode")

    }


    /**
     * 用户查询分页
     */
    override fun  findUserListPage(page: Page<SysUser>,user: SysUserDto): Page<SysUserDto>? {
        val entityWrapper = Condition.wrapper<SysUser>()

        if (StringUtils.isNotBlank(user.username))entityWrapper.eq("username",user.username)
        if (StringUtils.isNotBlank(user.telephone))entityWrapper.eq("telephone",user.telephone)
        val page1 = this.selectPage(page, entityWrapper)
        val data = page1.records
        val list = data.stream().map { a ->
            val dept = sysDeptServiceImpl.selectById(a.deptId)

            var dto = SysUserDto()
            BeanUtils.copyProperties(a, dto)
            dto.deptName = dept.name
            dto.password = "******"
            dto
        }.collect(Collectors.toList())
        val page2 = Page<SysUserDto>()

        page2.current=page1.current
        page2.records=list
        page2.size=page1.size
        page2.total=page1.total

        return  page2

    }
}
