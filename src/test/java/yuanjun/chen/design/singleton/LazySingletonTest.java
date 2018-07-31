/**
 * 
 */
package yuanjun.chen.design.singleton;

import org.junit.Test;

/**
 * @author hp
 *
 */
public class LazySingletonTest {
	@Test
	public void lazySingletonTest() throws Exception {
		int nThread = 1000;
		int loopPerThread = 10000;
		Thread[] threads = new Thread[nThread];
		for (int i = 0; i < nThread; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < loopPerThread; j++) {
						LazySingleton.getInstance().GloballyInc();
					}
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
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < loopPerThread; j++) {
						LazySingleton.getInstanceByStaticSync().GloballyInc();
					}
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
