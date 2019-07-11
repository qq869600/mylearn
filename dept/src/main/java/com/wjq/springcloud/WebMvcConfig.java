package com.wjq.springcloud;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wu-junqiang
 * @date 2019/7/10
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        // 添加安全校验拦截器
        this.addMyInterceptor(registry);
    }

    private void addMyInterceptor(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new HandlerInterceptorAdapter(){
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("请求路径："+request.getRequestURL());
                return true;
            }
        });
        // 拦截所有路径
        addInterceptor.addPathPatterns("/**");
    }
}
