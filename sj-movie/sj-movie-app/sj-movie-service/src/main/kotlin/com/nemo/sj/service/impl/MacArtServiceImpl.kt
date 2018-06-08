package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacArt;
import com.nemo.sj.mapper.MacArtMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacArtService
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
open class MacArtServiceImpl : ServiceImpl<MacArtMapper, MacArt>(), IMacArtService {

}
