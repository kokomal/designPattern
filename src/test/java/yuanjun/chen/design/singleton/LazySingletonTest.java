/**  
 * @Title: LazySingletonTest.java   
 * @Package: yuanjun.chen.design.singleton   
 * @Description: 懒汉单例模式 性能测试 
 * @author: 陈元俊     
 * @date: 2018年8月1日 下午2:24:06   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.singleton;

import org.junit.Test;

/**   
 * @ClassName: LazySingletonTest   
 * @Description: 懒汉单例模式 性能测试 
 * @author: 陈元俊 
 * @date: 2018年8月1日 下午2:24:06  
 */
public class LazySingletonTest {
	@Test
	public void lazySingletonTest() throws Exception {
		int nThread = 1000;
		int loopPerThread = 10000;
		Thread[] threads = new Thread[nThread];
		for (int i = 0; i < nThread; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < loopPerThread; j++) {
					LazySingleton.getInstance().globallyInc();
				}
			});
			threads[i].start();
		}
		for (int i = 0; i < nThread; i++) {
			threads[i].join();
		}
		System.out.println("finally counts are " + LazySingleton.getInstance().howManyCounts());
	}
	
	@Test
	public void lazySingletonTest2() throws Exception {
		int nThread = 1000;
		int loopPerThread = 10000;
		Thread[] threads = new Thread[nThread];
		for (int i = 0; i < nThread; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < loopPerThread; j++) {
					LazySingleton.getInstanceByStaticSync().globallyInc();
				}
			});
			threads[i].start();
		}
		for (int i = 0; i < nThread; i++) {
			threads[i].join();
		}
		System.out.println("finally counts are " + LazySingleton.getInstance().howManyCounts());
	}
}
