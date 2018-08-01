package com.nemo.sj.system.controller;


import com.baomidou.mybatisplus.mapper.Condition
import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.common.JsonData
import com.nemo.sj.dto.SysRoleDto
import com.nemo.sj.dto.UserDto
import com.nemo.sj.exception.PermissionException
import com.nemo.sj.system.common.util.MD5Util
import com.nemo.sj.system.entity.SysUser
import com.nemo.sj.system.service.ISysRoleUserService
import com.nemo.sj.system.service.ISysUserService
import com.nemo.sj.system.vo.SysUserDto
import com.nemo.sj.util.IpUtil
import org.apache.coyote.http11.Constants.a
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@RestController
@RequestMapping("/system/sysUser")
class SysUserController {
    @Autowired
    lateinit var isysUserService: ISysUserService

    @Autowired
    lateinit var iSysRoleUserService: ISysRoleUserService

    lateinit var data: JsonData
    @GetMapping
    fun void(): JsonData {
        throw PermissionException("这是异常")

        return JsonData.Companion.success("test")
    }

    /**
     * 登陆
     */
    @PostMapping("/login")
    fun systemUserLogin(user: SysUserDto): SysUser? {
        //转化类
        val userSys = SysUserDto.doForward(user)
        return isysUserService.login(userSys)

    }

    /**
     * 通过用户名查询用户信息
     */
    @GetMapping("/findUserByUsername/{username}")
    fun findByUserName(@PathVariable username:String):UserDto?{
        val entityWrapper = Condition.wrapper<SysUser>()
        entityWrapper.eq("username",username);
        val sysUser = isysUserService.selectOne(entityWrapper)
        if(sysUser==null){
            return null
        }
        var userDto=UserDto()
        BeanUtils.copyProperties(sysUser,userDto)

        val roleListByUserId = iSysRoleUserService.findRoleListByUserId(sysUser.id)
        val map = roleListByUserId.stream().map { a ->
            var dto = SysRoleDto()
            BeanUtils.copyProperties(a, dto)
            dto
        }.collect(Collectors.toList())
        userDto.roleList=map;
        return  userDto
    }

    /**
     * 通过部门id  用户列表
     * @param depId 部门id
     */
    @GetMapping("/dept/{depid}")
    fun findByDepIdList(@PathVariable depid: Int): List<SysUser> {
        return isysUserService.findByDepIdList(depid)
    }


    @GetMapping("/page")
    fun findUserListPage(page: Page<SysUser>, user: SysUserDto,startTime:Date?,endTime:Date?): Page<SysUserDto>? {

        return isysUserService.findUserListPage(page,user,startTime,endTime)
    }

    /**
     * 跟新用户信息
     */
    @PostMapping("/updateinfo")
    fun updateOrUpdateUser(req: HttpServletRequest, user: SysUserDto): SysUser? {
        val updateUser = SysUserDto.doForward(user)
        if (updateUser.id==null){
            updateUser.password=MD5Util.md5Digest("123456")
        }
        updateUser.operateTime= Date()
        updateUser.operateIp=IpUtil.getRemoteIp(req)
        isysUserService.insertOrUpdate(updateUser)
        return updateUser;
    }


}
