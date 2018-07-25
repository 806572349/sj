package com.nemo.sj.system.controller;


import com.nemo.sj.common.JsonData
import com.nemo.sj.exception.PermissionException
import com.nemo.sj.system.common.util.MD5Util
import com.nemo.sj.system.entity.SysUser
import com.nemo.sj.system.service.ISysUserService
import com.nemo.sj.system.vo.SysUserDto
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

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
     * 通过部门id  用户列表
     * @param depId 部门id
     */
    @GetMapping("/dept/{depid}")
    fun findByDepIdList(@PathVariable depid: Int): List<SysUser> {
        return isysUserService.findByDepIdList(depid)
    }


}
