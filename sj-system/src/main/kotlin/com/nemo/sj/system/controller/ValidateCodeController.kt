package com.nemo.sj.system.controller

import com.google.code.kaptcha.Producer
import com.nemo.sj.common.JsonData
import com.nemo.sj.constant.SecurityConstants
import com.nemo.sj.system.service.ISysUserService
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.imageio.ImageIO
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *  create by Nemo
 *  2018/7/26  11:26
 */
@RestController
class ValidateCodeController {

    @Autowired
    lateinit var producer: Producer


    @Autowired
    lateinit var  iSysUserService: ISysUserService
    /**
     * 创建验证码
     *
     * @param request request
     * @throws Exception
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX)
    @Throws(Exception::class)
    fun createCode(randomStr: String, request: HttpServletRequest, response: HttpServletResponse) {

        response.setHeader("Cache-Control", "no-store, no-cache")
        response.contentType = "image/jpeg"
        //生成文字验证码
        val text = producer.createText()
        //生成图片验证码
        val image = producer.createImage(text)
        iSysUserService.saveImageCode(randomStr, text)
        val out = response.outputStream
        ImageIO.write(image, "JPEG", out)
        IOUtils.closeQuietly(out)
    }

    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_HASHCODE_URL_PREFIX )
    @Throws(Exception::class)
    fun createHashCode(): JsonData {
        return iSysUserService.saveHashCode()
    }

}