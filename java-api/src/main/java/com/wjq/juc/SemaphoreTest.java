package com.wjq.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wu-junqiang
 * @date 2019/6/17
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore sp = new Semaphore(2);
	    for (int i = 0; i < 3; i++) {
            new Thread(()-> {
                for(;;) {
                    try {
                        sp.acquire();
                        System.out.println(Thread.currentThread().getName()+"获得一个信号量");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println(Thread.currentThread().getName()+"释放");
                        sp.release();
                    }
                }
            },"线程"+i).start();
        }
    }
}
