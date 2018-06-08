package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacArtType;
import com.nemo.sj.mapper.MacArtTypeMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacArtTypeService
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
open class MacArtTypeServiceImpl : ServiceImpl<MacArtTypeMapper, MacArtType>(), IMacArtTypeService {

}
