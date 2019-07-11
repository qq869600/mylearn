package com.wjq.springcloud;

/**
 * @author wu-junqiang
 * @date 2019/7/11
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class EmployeeServer {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServer.class,args);
    }
}
