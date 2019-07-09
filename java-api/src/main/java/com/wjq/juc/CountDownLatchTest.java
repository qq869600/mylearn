package com.wjq.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author wu-junqiang
 * @date 2019/6/17
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
	    CountDownLatch cdl = new CountDownLatch(8);
        for (int i = 0; i < 8; i++) {
              new Thread(()-> {
                   try {
                       System.out.println(Thread.currentThread().getName()+"完成");
                       cdl.countDown();
                   } catch (Exception e) {
                       e.printStackTrace();
                   } finally {

                   }
               },"线程"+i).start();
          }
          try {
            cdl.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("完成");
    }
}
