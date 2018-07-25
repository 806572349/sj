package com.nemo.sj.fegin.fallback;

import com.nemo.sj.dto.AclDto;
import com.nemo.sj.fegin.AclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Nemo
 * 2018/7/25  21:16
 */
@Slf4j
@Service
public class AclFallbackImpl implements AclService {

    @Override
    public List<AclDto> findAclByRoleName(String roleName) {
        log.error("查询roleName 失败");
        return null;
    }
}
