package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacUserGroup;
import com.nemo.sj.mapper.MacUserGroupMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacUserGroupService
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
open class MacUserGroupServiceImpl : ServiceImpl<MacUserGroupMapper, MacUserGroup>(), IMacUserGroupService {

}
