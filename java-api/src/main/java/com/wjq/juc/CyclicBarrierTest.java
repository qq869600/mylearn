package com.wjq.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wu-junqiang
 * @date 2019/6/17
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
	    CyclicBarrier cb = new CyclicBarrier(8,()->{
	      System.out.println("召唤神龙。。");
	    });
	     for (int i = 0; i < 8; i++) {
         new Thread(()-> {
              try {
                  System.out.println(Thread.currentThread().getName()+"准备就绪");
                  cb.await();
                  System.out.println(Thread.currentThread().getName()+"开工");
              } catch (BrokenBarrierException e) {
                  e.printStackTrace();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {

              }
          },"线程"+i).start();
	     }
    }
}
