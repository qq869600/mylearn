package com.wjq.juc;

import java.util.concurrent.locks.LockSupport;

public class ThreadParkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    System.out.println("运行中。。。。"+(i++));
                    LockSupport.park();
                }
            }
        };
        th.setDaemon(true);//当所有非守护线程挂掉，所有守护进程将退出
        th.start();
        int i=0;
        while (i++<100){
            Thread.sleep(10);
            LockSupport.unpark(th);
        }
    }
}