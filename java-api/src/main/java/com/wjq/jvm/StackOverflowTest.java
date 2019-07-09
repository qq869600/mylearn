package com.wjq.jvm;

/**
 * @author wu-junqiang
 * @date 2019/6/30
 */
public class StackOverflowTest {
    public static void main(String[] args) {
        digui();
    }

    private static void digui() {
        digui();
    }
}
