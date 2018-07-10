package com.nemo.sj.system.test

import org.hibernate.validator.constraints.Length

/**
 *  create by Nemo
 *  2018/7/10  23:22
 */
class TestVo {

    @Length(min = 1, max = 2, message = "asd")
    var test:String?=null
}