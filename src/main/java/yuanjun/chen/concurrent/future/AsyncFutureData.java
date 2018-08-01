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

/**
 * @ClassName: AsyncDataMachine
 * @Description: 比较粗糙的一个demo，展示future/get模式的精髓，即进料在先，交付在后
 * 如果进料还在处理，则在完成之前任何时候去fetch都是阻塞等待，直到最终完成后返回dto
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:21:26
 */
public class AsyncFutureData<T extends ProtoDTO> implements IGenericFuture<T> {
    private static final Logger logger = LogManager.getLogger(AsyncFutureData.class);
    
    private volatile boolean isReady = false;
    private T dto = null;

    // 进料，可能处理很长时间
    @SuppressWarnings("unchecked")
    public synchronized void sendInData(String name, Double price, Class<T> clazz) throws Exception {
        if (isReady) // 一般场合不允许二次进料，否则先前的数据就会丢了，如果先前有人在wait，则会得到错误的结果
            return;
        Thread.sleep(2000);
        if (clazz == ParcelDTO.class) { // 这里类似工厂构建方法
            ParcelDTO pd = new ParcelDTO();
            pd.setDate(new Date());
            pd.setName(name + " STAMPED");
            pd.setPrice(price);
            this.dto = (T) pd;
        }
        isReady = true;
        logger.info("done constuct " + dto);
        notifyAll();
    }

    // 如果还没好，则阻塞等待
    @Override
    public synchronized T fetchData() throws Exception {
        while (!isReady) {
            wait();
        }
        return this.dto;
    }
}
