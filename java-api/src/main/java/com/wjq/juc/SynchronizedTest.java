package com.wjq.juc;

import java.util.ArrayList;

/**
 * @author wu-junqiang
 * @date 2019/6/17
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        ArrayList<Thread> list = new ArrayList<Thread>();
        final Object lock = new Object();
        for (int i = 0; i < 8; i++) {
            Thread th = new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "等等");
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + "开工");
                        Thread.sleep(1000);
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程" + i);
            th.start();
            list.add(th);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            lock.notify();
        }
//        for (Thread thread : list) {
//            thread.interrupt();
//        }
    }
}
