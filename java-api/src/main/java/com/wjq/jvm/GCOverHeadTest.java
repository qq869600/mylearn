package com.wjq.jvm;

import java.util.ArrayList;

/**
 * -Xms10m -Xmx10m -XX:MaxDirectMemorySize=10m
 * @author wu-junqiang
 * @date 2019/7/8
 */
public class GCOverHeadTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
            System.out.println("haha"+i);
        }
    }
}
