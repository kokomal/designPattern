/**
 * @Title: IGenericFuture.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:02:34
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future;

import yuanjun.chen.concurrent.future.dto.PackageDTO;

/**
 * @ClassName: IGenericFuture
 * @Description: 通用获取未来包裹的接口，数据类型为T
 * @author: 陈元俊
 * @date: 2018年8月1日 上午10:02:34
 */
public interface IGenericFuturePackage<T extends PackageDTO> {
    T fetchPackage() throws Exception;
    void sendInPackage(String name, Double price, Class<T> clazz) throws Exception;
}
