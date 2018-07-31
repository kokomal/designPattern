/**
 * @Title: CacheAsideDemo.java
 * @Package: yuanjun.chen.cache
 * @Description: 缓存失效相关设计模式demo
 * @author: 陈元俊
 * @date: 2018年7月31日 下午1:13:06
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.cache;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yuanjun.chen.common.BadPractice;

/**
 * @ClassName: CacheAsideDemo
 * @Description: 缓存失效相关设计模式demo
 * @author: 陈元俊
 * @date: 2018年7月31日 下午1:13:06
 */
public class CacheAsideDemo {
    private static final Logger logger = LogManager.getLogger(CacheAsideDemo.class);
    private static final String TOP_HANDSOME = "topHandsome";
    public static Map<String, String> cache = new HashMap<String, String>();
    public static Map<String, String> db = new HashMap<String, String>(); // db always have val
    static {
        db.put(TOP_HANDSOME, "潘安");
        cache.put(TOP_HANDSOME, "潘安");
    }

    /**
     * 
     * 脆弱之处在于，缓存删除---db更新之间有比较大的gap，在此期间，如果穿透cache来读取db旧值， 并且误认为db的数据优于空的缓存 那就万劫不复了
     * 因此需要在更新的时候，不要先删除缓存，而是在db更新完毕的一瞬间去删除缓存（非更新） 在读取的时候，如果发现没有缓存则从db里面读取后放入缓存内
     * 优势在于，db可信度高，仅在更新的时候，db才暴露，并且db极大可能是最新值
     * 旧的cache生存周期将极短，这是因为一旦有数据更新，最终会删除旧的缓存，不会存在badWrite那样旧cache逆转的情况
     * 
     */
    @BadPractice
    public static void badWrite(String key, String val) throws Exception {
        if (cache.containsKey(key)) {
            logger.info("BadWrite=== find key " + key + " in cache, delete it...");
            cache.remove(key); // 1.删了cache-潘安，失去cache的保护，db直接暴露了
            logger.info("BadWrite=== starting to update db..."); // 2.准备写入将胡歌写入db
            Thread.sleep(1000); // 时间可能比较长
            db.put(key, val); // 7.新值进入db-胡歌
        } else {
            db.put(key, val);
        }
    }

    @BadPractice
    public static String badRead(String key) {
        try {
            Thread.sleep(200); // 3.read略晚一点开始
        } catch (InterruptedException e) {
        }
        if (!cache.containsKey(key)) { // 4.cache没有读到
            logger.info("BadRead=== cannot find " + key + " in cache, try db instead...");
            logger.info("BadRead=== find " + key + " in db, which is " + db.get(key)); // 5.从db读旧数据-潘安
            logger.info("BadRead=== since cache no value, starting to update cache...");
            cache.put(key, db.get(key)); // 6.将旧数据放入缓存-潘安
            logger.info("BadRead=== cache successfully updated val " + db.get(key));
            return db.get(key);
        } else {
            logger.info("BadRead=== instanly find " + key + " in cache, which is " + cache.get(key));
            return cache.get(key);
        }
    }

    public static void cacheAsideWrite(String key, String val) throws Exception {
        if (cache.containsKey(key)) {
            logger.info("CacheAsideWrite=== starting to update db..."); // 1.准备写入将胡歌写入db
            Thread.sleep(1000); // 2.db可能更新的很慢
            db.put(key, val); // 7.新值进入db-胡歌
            Thread.sleep(1); // db更新成功后立诛曹无伤
            cache.remove(key); // 8.删了旧cache-潘安
        } else {
            db.put(key, val); // 不存在，也只写db，不操作cache
        }
    }

    @BadPractice
    public static String cacheAsideRead(String key) {
        try {
            Thread.sleep(200); // 3.read略晚一点开始
        } catch (InterruptedException e) {
        }
        if (!cache.containsKey(key)) { // 4.cache没有读到
            logger.info("CacheAsideRead=== cannot find " + key + " in cache, try db instead...");
            logger.info("CacheAsideRead=== find " + key + " in db, which is " + db.get(key)); // 5.从db读旧数据-潘安
            logger.info("CacheAsideRead=== since cache no value, starting to update cache...");
            cache.put(key, db.get(key)); // 6.将旧数据放入缓存-潘安
            logger.info("CacheAsideRead=== cache successfully updated val " + db.get(key));
            return db.get(key);
        } else {
            logger.info("CacheAsideRead=== instanly find " + key + " in cache, which is " + cache.get(key));
            return cache.get(key);
        }
    }

    public static void main(String[] args) throws Exception {}
}
