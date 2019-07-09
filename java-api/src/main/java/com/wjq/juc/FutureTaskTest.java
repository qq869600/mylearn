package com.wjq.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wu-junqiang
 * @date 2019/6/23
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Long> future = new FutureTask<Long>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("开始调用");
                return 10000L;
            }
        });
        new Thread(future).start();
        new Thread(future).start();//future只会执行一次
        Long val = future.get();
        System.out.println(val);

    }
}
