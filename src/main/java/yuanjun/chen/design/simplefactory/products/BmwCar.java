/**
 * @Title: BmwCar.java
 * @Package: yuanjun.chen.design.simplefactory
 * @Description: BmwCar具体类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:50:49
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory.products;

import yuanjun.chen.design.simplefactory.CarFactory;

/**
 * @ClassName: BmwCar
 * @Description: BmwCar具体类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:50:49
 */
public class BmwCar extends Car {

    @Override
    String getBrand() {
        return CarFactory.CarType.BMW.name();
    }

}
