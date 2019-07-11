package com.wjq.springcloud.feign;

import com.wjq.springcloud.api.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wu-junqiang
 * @date 2019/7/11
 */
@Component
public class DeptFeignClientFallbackFactory implements FallbackFactory<DeptFeignClient> {
    @Override
    public DeptFeignClient create(Throwable throwable) {
        return new DeptFeignClient() {
            @Override
            public Dept get(String id) {
                return new Dept("-1","请求服务异常");
            }

            @Override
            public Dept getDept(String id) {
                return new Dept("-2","请求服务异常2");
            }
        };
    }
}
