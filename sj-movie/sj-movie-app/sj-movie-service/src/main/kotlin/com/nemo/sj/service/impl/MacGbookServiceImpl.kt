package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacGbook;
import com.nemo.sj.mapper.MacGbookMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacGbookService
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
open class MacGbookServiceImpl : ServiceImpl<MacGbookMapper, MacGbook>(), IMacGbookService {

}
