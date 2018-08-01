/**
 * @Title: AsyncDataFetchMachine.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:25:06
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import yuanjun.chen.concurrent.future.dto.PackageDTO;

/**
 * @ClassName: AsyncDataFetchMachine
 * @Description: 类似于专属parcelDTO的静态工厂
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:25:06
 */
public class AsyncPackageFetchMachine {
    
    public static <T extends PackageDTO> IGenericFuturePackage<T> fetchAsyncData(String name, Double price, Class<T> clazz) {
        AsyncFuturePackage<T> future = new AsyncFuturePackage<T>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    future.sendInPackage(name, price, clazz); // 另起线程去生成数据
                } catch (Exception e) {
                }
            }
        }).start();
        return future; // 无阻塞返回壳子
    }
}
