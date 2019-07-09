package com.wjq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wu-junqiang
 * @date 2019/6/30
 */
public class JavaHeapSpaceTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();
        while (true){
            list.add(new byte[1024*1024]);
        }
    }
}
