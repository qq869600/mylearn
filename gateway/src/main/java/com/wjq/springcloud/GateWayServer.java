package com.wjq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author wu-junqiang
 * @date 2019/7/10
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayServer {
    public static void main(String[] args) {
        SpringApplication.run(GateWayServer.class,args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("SPRINGCLOUD-DEPT",p -> p
                    .path("/dept/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("lb://SPRINGCLOUD-DEPT"))
            .route("SPRINGCLOUD-EMPLOYEE",p -> p
                    .path("/emp/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("lb://SPRINGCLOUD-EMPLOYEE"))
            .build();
    }
}
