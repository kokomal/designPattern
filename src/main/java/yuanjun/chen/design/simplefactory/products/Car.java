/**
 * @Title: Car.java
 * @Package: yuanjun.chen.design.simplefactory
 * @Description: 抽象类car
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:48:28
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: Car
 * @Description: 抽象类car
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:48:28
 */
public abstract class Car {
    private static final Logger logger = LogManager.getLogger(Car.class);
    abstract String getBrand();
    
    public void drive() {
        proto("driving");
    }

    public void park() {
        proto("parking");
    }

    public void injectGas() {
        proto("injecting gas");
    }

    public void proto(String action) {
        logger.info(getBrand() + " is " + action);
    }
}
