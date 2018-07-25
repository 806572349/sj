package com.nemo.sj.fegin;

import com.nemo.sj.config.FeginConfig;
import com.nemo.sj.fegin.fallback.UserServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * create by Nemo
 * 2018/7/25  21:16
 */
@FeignClient(name = "sj-sys", fallback = UserServiceFallbackImpl.class,configuration = FeginConfig.class)
public interface AclService {


}
