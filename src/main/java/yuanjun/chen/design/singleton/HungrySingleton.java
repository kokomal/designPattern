/**
 * 
 */
package yuanjun.chen.design.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 饿汉单例采用初始化时（类加载）时即完成
 */
public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();
	private AtomicInteger count;

	public static void trigger() {
		//dummy!触发类加载和静态代码块初始化
	}
	
	private HungrySingleton() {
		System.out.println("hungry singleton is newing instance");
		this.count = new AtomicInteger(0);
	}

	public static HungrySingleton getInstance() {
		return instance;
	}

	public int globallyInc() {
		return this.count.incrementAndGet();
	}

	public int howManyCounts() {
		return this.count.get();
	}

	public static void main(String[] args) {
		// 这里之所以被初始化是因为main属于此类的静态方法
		System.out.println("just soso");
	}
}
