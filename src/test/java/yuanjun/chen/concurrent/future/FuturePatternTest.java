/**
 * @Title: FuturePatternTest.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:31:37
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @ClassName: FuturePatternTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:31:37
 */
public class FuturePatternTest {
    private static final Logger logger = LogManager.getLogger(FuturePatternTest.class);

    @Test
    public void testFuture() throws Exception {
        IGenericFuture<ParcelDTO> futureData = AsyncDataFetchMachine.fetchAsyncData("pork", 99.33, ParcelDTO.class); // 进料，获得一个壳子
        logger.info("while waiting, do something else11!!");
        logger.info("while waiting, do something else22!!");
        manyPeopleWaitForYou(futureData);
    }

    private static void manyPeopleWaitForYou(IGenericFuture<ParcelDTO> futureData) throws Exception {
        Thread[] tl = new Thread[100];
        for (int i = 0; i < 100; i++) { // 100个线程在等待取货
            tl[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ParcelDTO dto = futureData.fetchData();
                        logger.info(Thread.currentThread().getName() + " get the parcel " + dto);
                    } catch (Exception e) {
                    }
                }
            });
            tl[i].start();
        }
        for (int i = 0; i < 100; i++) { // 100个线程在等待取货
            tl[i].join();
        }
        logger.info("finished");
        
    }
}
