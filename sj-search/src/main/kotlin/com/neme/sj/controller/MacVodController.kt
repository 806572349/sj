package com.neme.sj.controller

//import com.alibaba.dubbo.config.annotation.Reference
import com.neme.sj.dao.MavVodDao
import com.neme.sj.repo.MacVod
import jdk.nashorn.internal.ir.annotations.Reference
//import com.nemo.sj.rpc.IMacVodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *  create by Nemo
 *  2018/6/11  14:26
 */

@RequestMapping("/search")
@RestController
class MacVodController {
    @Autowired
    lateinit var mavVodDao: MavVodDao;


    @GetMapping("/test")
    fun test2() {
        var model = MacVod().apply {
            dName = "666"
            dId = 3
        }
        val macVod = mavVodDao.save(model)

    }


    @GetMapping("/{id}")
    fun test(@PathVariable id:Int): MacVod {
        val macVod = mavVodDao.findById(id).get()
        return macVod
    }


}