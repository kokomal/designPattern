/**
 * 
 */
package yuanjun.chen.design.singleton;

import org.junit.Test;

/**
 * @author hp 伪饿汉，本质上的初始化还是放到了第一次getInstance的时候！
 */
public class HungrySingletonTest {
	@Test
	public void hungrySingletonTest() throws Exception {
		System.out.println("begin!");
		// 刺激类初始化,但是是不可能在此初始化静态成员的！
		System.out.println(HungrySingleton.class.getName());
		System.out.println("pending");
		// HungrySingleton.getInstance(); // 显式调用new，必然初始化
		// 尝试暴力load饿汉类，仍然不行
		Thread.currentThread().getContextClassLoader().loadClass("yuanjun.chen.design.singleton.HungrySingleton");
		System.out.println("pending");
		HungrySingleton.trigger(); // 显式调用某一初始化方法，可以触发静态成员的初始化
		System.out.println("show yourself");
		int nThread = 1000;
		int loopPerThread = 10000;
		Thread[] threads = new Thread[nThread];
		for (int i = 0; i < nThread; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < loopPerThread; j++) {
						HungrySingleton.getInstance().GloballyInc();
					}
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
