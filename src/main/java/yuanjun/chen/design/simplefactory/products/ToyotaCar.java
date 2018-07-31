/**
 * @Title: ToyotaCar.java
 * @Package: yuanjun.chen.design.simplefactory.products
 * @Description: ToyotaCar具体类
 * @author: 陈元俊
 * @date: 2018年7月31日 上午8:36:59
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory.products;

import yuanjun.chen.design.simplefactory.factory.CarStaticFactory;

/**
 * @ClassName: ToyotaCar
 * @Description: ToyotaCar具体类
 * @author: 陈元俊
 * @date: 2018年7月31日 上午8:36:59
 */
public class ToyotaCar extends Car {

    @Override
    String getBrand() {
        return CarStaticFactory.CarType.TOYOTA.name();
    }
}
