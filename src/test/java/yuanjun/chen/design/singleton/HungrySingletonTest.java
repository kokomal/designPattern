/**
 * @Title: HungrySingletonTest.java
 * @Package: yuanjun.chen.design.singleton
 * @Description: 饿汉单例模式 性能测试
 * @author: 陈元俊
 * @date: 2018年8月1日 下午2:24:06
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.singleton;

import org.junit.Test;
import yuanjun.chen.common.BadPractice;

/**
 * @ClassName: HungrySingletonTest
 * @Description: 伪饿汉，本质上的初始化时机待定，如果一切不变，还是放到了第一次getInstance的时候！
 * @author: 陈元俊
 * @date: 2018年8月1日 下午2:24:06
 */
public class HungrySingletonTest {

    @Test
    public void hungryTest() throws Exception {
        tryLoadClass001();
        tryLoadClass002();
        tryLoadClass003();
        tryLoadClass004();
        exec();
    }

    public void tryLoadClass001() {
        System.out.println("---begin1---");
        // 刺激类初始化,但是是不可能在此初始化静态成员的！
        synchronized (HungrySingleton.class) {
            System.out.println("i locked you, but dead still!");
        }
    }

    public void tryLoadClass002() throws Exception {
        System.out.println("---begin2---");
        // 尝试暴力load饿汉类，仍然不行
        Thread.currentThread().getContextClassLoader().loadClass("yuanjun.chen.design.singleton.HungrySingleton");
        System.out.println("i loaded you, but dead still!");
    }

    @BadPractice
    public void tryLoadClass003() {
        System.out.println("---begin3---");
        // 尝试声明变量，而不访问其静态成员或者方法，必然不行
        HungrySingleton h = null;
    }

    public void tryLoadClass004() {
        System.out.println("---begin4---");
        // 到此才真正进行加载！
        HungrySingleton.trigger(); // 显式调用某一初始化方法，可以触发静态成员的初始化
    }

    public void exec() throws Exception {
        System.out.println("---begin4---"); // 正式开始执行
        testSingleton();
    }

    private void testSingleton() throws InterruptedException {
        int nThread = 1000;
        int loopPerThread = 10000;
        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < loopPerThread; j++) {
                    HungrySingleton.getInstance().globallyInc();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < nThread; i++) {
            threads[i].join();
        }
        System.out.println("finally counts are " + HungrySingleton.getInstance().howManyCounts());
    }
}
