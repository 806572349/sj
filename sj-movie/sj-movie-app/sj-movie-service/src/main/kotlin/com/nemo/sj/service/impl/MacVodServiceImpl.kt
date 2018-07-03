package com.nemo.sj.service.impl;

//import com.alibaba.dubbo.config.annotation.Service
import com.alibaba.dubbo.config.annotation.Service
import com.baomidou.mybatisplus.plugins.Page
import com.nemo.sj.entity.MacVod;
import com.nemo.sj.mapper.MacVodMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.dao.MacVodDao
import com.nemo.sj.params.MacVodParams
import com.nemo.sj.rpc.IMacVodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
@Component
@Service(interfaceClass= IMacVodService::class)
open class MacVodServiceImpl : ServiceImpl<MacVodMapper, MacVod>(), IMacVodService {


    @Autowired
    lateinit var macVodDao: MacVodDao

    override fun queryPage(page: Page<MacVod>, macVodParams: MacVodParams): Page<MacVod> {
        return this.selectPage(page,macVodDao.queryPage(macVodParams));
    }

     override fun findOne(macVod: MacVod) :MacVod{
        val data = macVodDao.findOne(macVod)
        return  data;
    }
}
