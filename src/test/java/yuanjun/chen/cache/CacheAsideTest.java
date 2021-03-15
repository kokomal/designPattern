/**
 * @Title: CacheAsideTest.java
 * @Package: yuanjun.chen.cache
 * @Description: Cache Aside Pattern测试
 * @author: 陈元俊
 * @date: 2018年7月31日 下午2:38:57
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @ClassName: CacheAsideTest
 * @Description: Cache Aside Pattern测试
 * @author: 陈元俊
 * @date: 2018年7月31日 下午2:38:57
 */
public class CacheAsideTest {
    private static final Logger logger = LogManager.getLogger(CacheAsideTest.class);
    protected static final String TOP_HANDSOME = "topHandsome";

    @Test
    public void badCacheRWTest() throws Exception {
        CacheAsideDemo.db.put(TOP_HANDSOME, "潘安"); // 初始化
        CacheAsideDemo.cache.put(TOP_HANDSOME, "潘安"); // 初始化
        Thread t1 = new Thread(() -> {
            try {
                CacheAsideDemo.badWrite(TOP_HANDSOME, "胡歌");
            } catch (Exception e) {
            }
        });
        Thread t2 = new Thread(() -> {
            String first = CacheAsideDemo.badRead(TOP_HANDSOME);
            logger.info("BadRead=== FIRST GET " + first);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info("BadRead=== FINALLY IN CACHE " + CacheAsideDemo.cache.get(TOP_HANDSOME));
        logger.info("BadRead=== FINALLY IN DB " + CacheAsideDemo.db.get(TOP_HANDSOME));
        logger.info(
                "BadRead=== From then on, read will always read from dirty cache " + CacheAsideDemo.badRead(TOP_HANDSOME));
    }

    @Test
    public void cacheAsideRWTest() throws Exception {
        CacheAsideDemo.db.put(TOP_HANDSOME, "潘安"); // 初始化
        CacheAsideDemo.cache.put(TOP_HANDSOME, "潘安"); // 初始化
        Thread t1 = new Thread(() -> {
            try {
                CacheAsideDemo.cacheAsideWrite(TOP_HANDSOME, "胡歌");
            } catch (Exception e) {
            }
        });
        Thread t2 = new Thread(() -> {
            String first = CacheAsideDemo.cacheAsideRead(TOP_HANDSOME);
            logger.info("CacheAsideRead=== FIRST GET " + first);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        logger.info("CacheAsideRead=== FIRST IN CACHE " + CacheAsideDemo.cache.get(TOP_HANDSOME)); // cache在第一次写的时候最终会删除
        logger.info("CacheAsideRead=== FIRST IN DB " + CacheAsideDemo.db.get(TOP_HANDSOME));
        logger.info("CacheAsideRead=== READ AGAIN GET " + CacheAsideDemo.cacheAsideRead(TOP_HANDSOME));
        logger.info("CacheAsideRead=== FINALLY IN CACHE " + CacheAsideDemo.cache.get(TOP_HANDSOME));
        logger.info("CacheAsideRead=== FINALLY IN DB " + CacheAsideDemo.db.get(TOP_HANDSOME));
    }
}
