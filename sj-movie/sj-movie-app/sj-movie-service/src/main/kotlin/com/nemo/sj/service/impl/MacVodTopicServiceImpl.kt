package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacVodTopic;
import com.nemo.sj.mapper.MacVodTopicMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacVodTopicService
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
open class MacVodTopicServiceImpl : ServiceImpl<MacVodTopicMapper, MacVodTopic>(), IMacVodTopicService {

}
