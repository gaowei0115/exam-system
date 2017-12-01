package com.exam.system.test;

/**
 * @packageName：com.exam.system.test
 * @desrciption:
 * @author: gaowei
 * @date： 2017-12-01 13:28
 * @history: (version) author date desc
 */
public class StaticTest {

    public void fun(int i) {
        StaticClass staticClass = new StaticClass(i);
//        System.out.println(staticClass.hashCode());
        staticClass.sys();
    }

    public static void main(String[] args) {
        StaticTest s1 = new StaticTest();
        s1.fun(1);

//        StaticTest s2 = new StaticTest();
        s1.fun(3);

        StaticTest s3 = new StaticTest();
        s3.fun(4);

    }

    private static class StaticClass{
        private int param;

        public StaticClass(int i) {
            this.param = i;
        }

        public void sys() {
            System.out.println(">>>" + param);
        }
    }
}
