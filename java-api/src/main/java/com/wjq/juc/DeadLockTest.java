package com.wjq.juc;

/**
 * @author wu-junqiang
 * @date 2019/6/23
 */
public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        //死锁
        new Thread(){
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"得到lock1");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"得到lock2");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"得到lock2");
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"得到lock1");
                    }
                }
            }
        }.start();
    }
}
