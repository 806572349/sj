package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacVodClass;
import com.nemo.sj.mapper.MacVodClassMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacVodClassService
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
open class MacVodClassServiceImpl : ServiceImpl<MacVodClassMapper, MacVodClass>(), IMacVodClassService {

}
