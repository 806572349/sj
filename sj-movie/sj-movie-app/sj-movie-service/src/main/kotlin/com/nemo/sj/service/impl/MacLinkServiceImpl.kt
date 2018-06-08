package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacLink;
import com.nemo.sj.mapper.MacLinkMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacLinkService
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
open class MacLinkServiceImpl : ServiceImpl<MacLinkMapper, MacLink>(), IMacLinkService {

}
