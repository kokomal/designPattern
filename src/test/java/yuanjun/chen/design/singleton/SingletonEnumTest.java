/**  
 * @Title: SingletonEnumTest.java   
 * @Package: yuanjun.chen.design.singleton   
 * @Description: 枚举单例模式 性能测试   
 * @author: 陈元俊     
 * @date: 2018年8月1日 下午2:24:06   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;

/**   
 * @ClassName: SingletonEnumTest   
 * @Description: 枚举单例模式 性能测试 
 * atomicTestSingletonEnum采用了AtomicInteger，大数据量的话性能高于重量级锁
 * unsafelyTestSingletonEnum妄图采用无锁的方式获得单例的实例后操作单例成员变量，很遗憾有严重的并发冲突
 * @author: 陈元俊 
 * @date: 2018年8月1日 下午2:24:06  
 */
@FixMethodOrder
public class SingletonEnumTest {
    private static final Logger logger = LogManager.getLogger(SingletonEnumTest.class);
    @Test
    public void testAll() throws Exception {
        testInit();
        atomicTestSingletonEnum();
        safelyTestSingletonEnum();
        unsafelyTestSingletonEnum();
    }
    
    public void testInit() throws Exception {
        logger.info("begin load class " + SingletonEnum.class); // 此时没有初始化
        logger.info("i think the init has not been done"); 
        SingletonEnum zz = SingletonEnum.INSTANCE; // 隐式调用，属于静态成员访问，开始初始化 
        // SingletonEnum.trigger(); // dummy 亦可引发初始化
        logger.info("i think the init has been done"); // Enum单例模式也是饿汉模式
    }
    
    public void atomicTestSingletonEnum() throws Exception {
        SingletonEnum.INSTANCE.reset();
        int nThread = 1000;
        int loopPerThread = 10000;
        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopPerThread; j++) {
                        SingletonEnum.INSTANCE.globallyInc();
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < nThread; i++) {
            threads[i].join();
        }
        logger.info("finally counts are " + SingletonEnum.INSTANCE.howManyCounts());
    }
    
    public void safelyTestSingletonEnum() throws Exception {
        SingletonEnum.INSTANCE.reset();
        logger.info("i think the init has been done"); // Enum单例模式也是饿汉模式
        int nThread = 1000;
        int loopPerThread = 10000;
        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopPerThread; j++) {
                        SingletonEnum.INSTANCE.safelyGloballyInc();
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < nThread; i++) {
            threads[i].join();
        }
        logger.info("finally counts are " + SingletonEnum.INSTANCE.safelyHowManyCounts());
    }
    
    public void unsafelyTestSingletonEnum() throws Exception {
        SingletonEnum.INSTANCE.reset();
        int nThread = 1000;
        int loopPerThread = 10000;
        Thread[] threads = new Thread[nThread];
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopPerThread; j++) {
                        SingletonEnum.INSTANCE.unsafelyGloballyInc();
                    }
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < nThread; i++) {
            threads[i].join();
        }
        logger.info("finally counts are " + SingletonEnum.INSTANCE.unsafelyHowManyCounts());
    }
}
