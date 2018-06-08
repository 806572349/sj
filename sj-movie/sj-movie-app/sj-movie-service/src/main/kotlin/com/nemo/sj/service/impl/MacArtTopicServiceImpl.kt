package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacArtTopic;
import com.nemo.sj.mapper.MacArtTopicMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacArtTopicService
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
open class MacArtTopicServiceImpl : ServiceImpl<MacArtTopicMapper, MacArtTopic>(), IMacArtTopicService {

}
