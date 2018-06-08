package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacUserVisit;
import com.nemo.sj.mapper.MacUserVisitMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacUserVisitService
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-06-08
 */
@Service
open class MacUserVisitServiceImpl : ServiceImpl<MacUserVisitMapper, MacUserVisit>(), IMacUserVisitService {

}
