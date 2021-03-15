/**
 * @Title: FuturePatternTest.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: Future模式的综合测试
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:31:37
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import yuanjun.chen.concurrent.future.dto.DHL_Package;
import yuanjun.chen.concurrent.future.dto.PackageDTO;
import yuanjun.chen.concurrent.future.dto.SF_Package;

/**
 * @ClassName: FuturePatternTest
 * @Description: Future模式的综合测试
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:31:37
 */
public class FuturePatternTest {
    private static final Logger logger = LogManager.getLogger(FuturePatternTest.class);

    @Test
    public void testFuture() throws Exception {
        IGenericFuturePackage<SF_Package> futureData =
                AsyncPackageFetchMachine.fetchAsyncData("新鲜芒果", 99.33, SF_Package.class); // 进料，获得一个壳子
        logger.info("while waiting, do something else like playing cards!!");
        logger.info("while waiting, do something else like watching TV!!");
        manyPeopleWaitForYou(futureData);
    }

    @Test
    public void testFuture2() throws Exception {
        IGenericFuturePackage<DHL_Package> futureData =
                AsyncPackageFetchMachine.fetchAsyncData("澳龙", 299.33, DHL_Package.class); // 进料，获得一个壳子
        logger.info("while waiting, do something else like playing cards!!");
        logger.info("while waiting, do something else like watching TV!!");
        manyPeopleWaitForYou(futureData);
    }

    @Test
    public void testFuture3() throws Exception {
        IGenericFuturePackage<PackageDTO> futureData =
                AsyncPackageFetchMachine.fetchAsyncData("不明炭疽包裹", 10.24, PackageDTO.class); // 进料，获得一个壳子
        logger.info("while waiting, do something else like playing cards!!");
        logger.info("while waiting, do something else like watching TV!!");
        manyPeopleWaitForYou(futureData);
    }

    private static <T extends PackageDTO> void manyPeopleWaitForYou(IGenericFuturePackage<T> futureData)
            throws Exception {
        Thread[] tl = new Thread[10];
        for (int i = 0; i < 10; i++) { // 100个线程在等待取货
            tl[i] = new Thread(() -> {
                try {
                    T dto = futureData.fetchPackage();
                    if (dto != null) {
                        logger.info(Thread.currentThread().getName() + " get the parcel " + dto);
                    } else {
                        logger.warn(Thread.currentThread().getName() + " fail to fetch the parcel.");
                    }
                } catch (Exception e) {
                    logger.error("error " + e);
                    return;
                }
            });
            tl[i].start();
        }
        for (int i = 0; i < 10; i++) { // 100个线程在等待取货
            tl[i].join();
        }
        logger.info("finished");

    }
}
