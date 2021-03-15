/**
 * @Title: SingletonEnum.java
 * @Package: yuanjun.chen.design.singleton
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月1日 下午2:21:19
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.singleton;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: SingletonEnum
 * @Description: 单元素枚举,虽然是单例，但成员变量的同步仍然不可大意，不信请参考unsafely开头的方法
 * @author: 陈元俊
 * @date: 2018年8月1日 下午2:21:19
 */
public enum SingletonEnum {
    INSTANCE(0, 0);
    private static final Logger logger = LogManager.getLogger(SingletonEnum.class);
    private AtomicInteger counts;
    private Integer counts2; // 非线程安全成员

    SingletonEnum(int counts, int counts2) {
        this.counts = new AtomicInteger(counts);
        this.counts2 = counts2;
    }

    public void reset() {
        logger.info("reset should be after init!");
        this.counts.set(0);
        this.counts2 = 0;
    }
    
    public int globallyInc() { // AtomicInteger对线程友好
        return this.counts.incrementAndGet();
    }

    public synchronized int safelyGloballyInc() { // 普通变量加锁
        return ++this.counts2; // 切记不可加在可变的变量上，尤其是会自动装箱的变量
    }

    public int unsafelyGloballyInc() { // 如果此处不加锁，++操作不是原子的，寄存器里面的值可能过期，因此必然会偏小
        return ++this.counts2;
    }

    public int howManyCounts() {
        return this.counts.get();
    }

    public synchronized int safelyHowManyCounts() {
        return this.counts2;
    }

    public int unsafelyHowManyCounts() {
        return this.counts2;
    }
}
