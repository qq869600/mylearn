package com.wjq.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wjq.springcloud.api.Dept;
import com.wjq.springcloud.api.Employee;
import com.wjq.springcloud.feign.DeptFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wu-junqiang
 * @date 2019/7/11
 */
@RestController
public class EmployeeController {

    @Autowired
    DeptFeignClient deptFeignClient;

    @RequestMapping("/get")
    public Object get(){
        Dept dept = deptFeignClient.get("99");
        return new Employee("123","wujun",dept);
    }
    @RequestMapping("/getEmp")
    public Object getEmp(){
        Dept dept = deptFeignClient.getDept("999");
        return new Employee("321","wwwww",dept);
    }
}
