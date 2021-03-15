/**
 * @Title: CarFactory.java
 * @Package: yuanjun.chen.design.simplefactory
 * @Description: Car工厂类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:53:55
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory.factory;

import yuanjun.chen.design.simplefactory.products.AudiCar;
import yuanjun.chen.design.simplefactory.products.BenzCar;
import yuanjun.chen.design.simplefactory.products.BmwCar;
import yuanjun.chen.design.simplefactory.products.Car;
import yuanjun.chen.design.simplefactory.products.TeslaCar;
import yuanjun.chen.design.simplefactory.products.ToyotaCar;

/**
 * @ClassName: CarFactory
 * @Description: Car工厂类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:53:55
 */
public class CarStaticFactory {
    public enum CarType {
        BMW, BENZ, AUDI, TESLA, TOYOTA
    }

    public static Car generateOneCar(CarType type) {
        switch (type) {
            case BMW:
                return new BmwCar();
            case AUDI:
                return new AudiCar();
            case TESLA:
                return new TeslaCar();
            case TOYOTA:
                return new ToyotaCar();
            case BENZ:
            default:
                return new BenzCar();
        }
    }

}
