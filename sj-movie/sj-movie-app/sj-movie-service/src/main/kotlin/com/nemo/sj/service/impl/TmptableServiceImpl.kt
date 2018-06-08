package com.nemo.sj.service.impl;

import com.nemo.sj.entity.Tmptable;
import com.nemo.sj.mapper.TmptableMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.ITmptableService
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
open class TmptableServiceImpl : ServiceImpl<TmptableMapper, Tmptable>(), ITmptableService {

}
