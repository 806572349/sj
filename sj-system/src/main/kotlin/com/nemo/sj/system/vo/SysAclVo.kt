package com.nemo.sj.system.vo

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
 *  create by Nemo
 *  2018/8/17  18:11
 */
class SysAclVo {

    @NotNull(message = "id不能空")
    var id: Int? = null

    /**
     * 权限名称
     */
    var name: String? = null
    /**
     * 请求的url
     */
    var url: String? = null

    /**
     * 类型，1：菜单，2：按钮，3：其他
     */
    @NotNull(message = "type不能空")
    @Min(value = 1)
    @Max(value =3)
    var type: Int? = null
    /**
     * 状态，1：正常，0：冻结
     */
    @Min(value = 0)
    @Max(value =1)
    @NotNull(message = "status不能空")
    var status: Int? = null
}