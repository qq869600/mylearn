package com.wjq.proxy;

/**
 * @author wu-junqiang
 * @date 2019/7/7
 */
public class Worker implements Person {
    @Override
    public void eat() {
        System.out.println("工人吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("工人睡觉");
    }
}
