package com.wjq.jvm;

import java.nio.ByteBuffer;

/**
 * -XX:MaxDirectMemorySize=5m
 * @author wu-junqiang
 * @date 2019/7/9
 */
public class DirectBufferMemoryTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
