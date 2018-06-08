package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacVodType;
import com.nemo.sj.mapper.MacVodTypeMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacVodTypeService
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
open class MacVodTypeServiceImpl : ServiceImpl<MacVodTypeMapper, MacVodType>(), IMacVodTypeService {

}
