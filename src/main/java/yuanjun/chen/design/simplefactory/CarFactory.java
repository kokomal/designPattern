/**
 * @Title: CarFactory.java
 * @Package: yuanjun.chen.design.simplefactory
 * @Description: Car工厂类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:53:55
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory;

/**
 * @ClassName: CarFactory
 * @Description: Car工厂类
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:53:55
 */
public class CarFactory {
    public enum CarType {
        BMW, BENZ;
    }

    public static Car generateOneCar(CarType type) {
        switch (type) {
            case BMW:
                return new BmwCar();
            case BENZ:
                return new BenzCar();
            default:
                return new BenzCar();
        }
    }
    
    public static void main(String[] args) {
        Car x = CarFactory.generateOneCar(CarType.BENZ);
        x.drive();
        x.injectGas();
        x.park();
    }
}
