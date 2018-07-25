package com.nemo.sj.fegin;

import com.nemo.sj.component.config.FeginConfig;
import com.nemo.sj.dto.AclDto;
import com.nemo.sj.fegin.fallback.AclFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * create by Nemo
 * 2018/7/25  21:16
 */
@FeignClient(name = "sj-sys", fallback = AclFallbackImpl.class,configuration = FeginConfig.class)
public interface AclService {


    @GetMapping("/system/sysAcl/findAclByRoleName/{roleName}")
    List<AclDto> findAclByRoleName(@PathVariable("roleName") String roleName);

}
