package com.nemo.sj.system.service.impl;

import com.nemo.sj.system.entity.SysDept;
import com.nemo.sj.system.mapper.SysDeptMapper;
import com.nemo.sj.system.service.ISysDeptService;
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
open class SysDeptServiceImpl : ServiceImpl<SysDeptMapper, SysDept>(), ISysDeptService {

}
