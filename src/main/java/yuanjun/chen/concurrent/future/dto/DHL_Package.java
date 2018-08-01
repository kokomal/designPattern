/**
 * @Title: ParcelDTO.java
 * @Package: yuanjun.chen.concurrent.future
 * @Description: 具体包裹类dto，无逻辑
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:15:38
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.concurrent.future.dto;

import java.io.Serializable;

/**
 * @ClassName: ParcelDTO
 * @Description: 具体包裹类dto，无逻辑
 * @author: 陈元俊
 * @date: 2018年8月1日 上午9:15:38
 */
public class DHL_Package extends PackageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String BRAND = "DHL_EXCELLENCY_SIMPLY_DELIVERED";
    @Override
    String getBrand() {
        return BRAND;
    }

}
