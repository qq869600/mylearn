package com.wjq.springcloud.feign;

import com.wjq.springcloud.api.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wu-junqiang
 * @date 2019/7/11
 */
@FeignClient(value = "springcloud-dept",fallbackFactory=DeptFeignClientFallbackFactory.class)
public interface DeptFeignClient {

    @RequestMapping("/get")
    public Dept get(@PathVariable("id") String id);

    @RequestMapping("/getDept")
    public Dept getDept(@PathVariable("id") String id);
}
