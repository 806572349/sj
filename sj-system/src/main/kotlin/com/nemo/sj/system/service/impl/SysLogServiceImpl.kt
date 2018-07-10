package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysLog;
import com.nemo.sj.system.mapper.SysLogMapper;
import com.nemo.sj.system.service.ISysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nemo
 * @since 2018-07-09
 */
@Service
open class SysLogServiceImpl : ServiceImpl<SysLogMapper, SysLog>(), ISysLogService {

}
