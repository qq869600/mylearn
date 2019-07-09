package com.wjq.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author wu-junqiang
 * @date 2019/6/17
 */
public class ForkJoinTest {
    private static long value = Integer.MAX_VALUE;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long t1 = System.currentTimeMillis();
        MyForkJoinTask task = new MyForkJoinTask(1, value);
        ForkJoinPool pool = new ForkJoinPool(8);
        ForkJoinTask<Long> future = pool.submit(task);
        System.out.println(future.get());
        System.out.println("并发框架耗时："+(System.currentTimeMillis()-t1));
        long t2 = System.currentTimeMillis();
        long result = 0;
        for(long i = 1; i<=value; i++){
            result += i;
        }
        System.out.println(result);
        System.out.println("单线程耗时："+(System.currentTimeMillis()-t2));
    }
}

/**
 * 计算任务
 */
class MyForkJoinTask extends RecursiveTask<Long> {

    private long start;

    private long end;
    public MyForkJoinTask(long start,long end){
        this.start=start;
        this.end=end;
    }
    @Override
    protected Long compute() {
        long result = 0;
        if (end - start > 100000000) {
            MyForkJoinTask task1 = new MyForkJoinTask(start,(end+start)/2);
            task1.fork();
            MyForkJoinTask task2 = new MyForkJoinTask((end+start)/2+1,end);
            task2.fork();
            result += task1.join()+task2.join();
        } else {
           for (long i = start;i<=end;i++){
               result += i;
           }
        }
        return result;
    }
}