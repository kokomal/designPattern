/**
 * 懒汉单例
 */
package yuanjun.chen.design.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 懒汉单例模式采用懒加载的方式进行初始化，好处是其在类加载的时候无需进行初始化
 * 问题在于如果第一次请求其单例实例的时候，可能会比较耗时
 * 本demo采用了两种同步方式进行instance的获得，性能不分伯仲
 */
public class LazySingleton {
	private static LazySingleton instance = null;
	private AtomicInteger count;

	private LazySingleton() {
		this.count = new AtomicInteger(0);
	}
	
	// 注意全局的递增无需任何加锁措施也能保持同步，这是由于单例的获得本身是独占的
	public int GloballyInc() { 
		return this.count.incrementAndGet();
	}

	public int howManyCounts() {
		return this.count.get();
	}

	public synchronized static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	public static LazySingleton getInstanceByStaticSync() {
		synchronized (LazySingleton.class) {
			if (instance == null) {
				instance = new LazySingleton();
			}
			return instance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread.currentThread().getContextClassLoader().loadClass("yuanjun.chen.design.singleton.HungrySingleton");
		System.out.println("after loading");
	}
}
