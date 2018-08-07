/**
 * @Title: AsyncDataMachine.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:21:26
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yuanjun.chen.concurrent.future.dto.DHL_Package;
import yuanjun.chen.concurrent.future.dto.PackageDTO;
import yuanjun.chen.concurrent.future.dto.SF_Package;

/**
 * @ClassName: AsyncDataMachine
 * @Description: 比较粗糙的一个demo，展示future/get模式的精髓，即进料在先，交付在后
 * 如果进料还在处理，则在完成之前任何时候去fetch都是阻塞等待，直到最终完成后返回dto
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:21:26
 */
public class AsyncFuturePackage <T extends PackageDTO> implements IGenericFuturePackage<T> {
    private static final Logger logger = LogManager.getLogger(AsyncFuturePackage.class);
    
    private volatile boolean isReady = false;
    private T dto = null;

    // 进料，可能处理很长时间
    @SuppressWarnings("unchecked")
    @Override
    public synchronized void sendInPackage(String name, Double price, Class<T> clazz) throws Exception {
        if (isReady) // 一般场合不允许二次进料，否则先前的数据就会丢了，如果先前有人在wait，则会得到错误的结果
            return;
        Thread.sleep(2000);
        // 这里类似工厂构建方法
        if (clazz == DHL_Package.class) { // DHL的包裹
            DHL_Package pd = new DHL_Package();
            pd.setDate(new Date());
            pd.setName(name); // 打上DHL的标签
            pd.setPrice(price * 1.2); // 他们家比较黑
            pd.brandTag();
            this.dto = (T) pd;
        } else if (clazz == SF_Package.class) { // 顺丰的包裹
            SF_Package pd = new SF_Package();
            pd.setDate(new Date());
            pd.setName(name); // 打上顺丰的标签
            pd.setPrice(price * 1.1); // 稍微好一点
            pd.brandTag();
            this.dto = (T) pd;
        } else { // 其他均非法，陷阱是可能传入一个抽象类
            isReady = true;
            this.dto = null;
            return;
        }
        isReady = true;
        logger.info("done constuct " + dto);
        notifyAll();
    }

    // 如果还没好，则阻塞等待
    @Override
    public synchronized T fetchPackage() throws Exception {
        while (!isReady) {
            wait();
        }
        return this.dto;
    }
}
