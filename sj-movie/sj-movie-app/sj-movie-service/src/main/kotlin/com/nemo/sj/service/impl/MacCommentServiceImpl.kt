package com.nemo.sj.service.impl;

import com.nemo.sj.entity.MacComment;
import com.nemo.sj.mapper.MacCommentMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nemo.sj.rpc.IMacCommentService
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
open class MacCommentServiceImpl : ServiceImpl<MacCommentMapper, MacComment>(), IMacCommentService {

}
