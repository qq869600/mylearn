package com.wjq.springcloud.controller;
import com.wjq.springcloud.api.Dept;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wu-junqiang
 * @date 2019/7/10
 */
@RestController
public class DeptController {
    @RequestMapping("getDept")
    public Object getDept(){
        return new Dept("99","哈哈");
    }
    @RequestMapping("get")
    public Object get() throws InterruptedException {
        Thread.sleep(5000);
        return new Dept("99","gggggg");
    }
}
