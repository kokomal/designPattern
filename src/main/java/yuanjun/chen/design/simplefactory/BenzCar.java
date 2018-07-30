/**
 * @Title: BenzCar.java
 * @Package: yuanjun.chen.design.simplefactory
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:50:49
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.simplefactory;

/**
 * @ClassName: BenzCar
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年7月30日 下午5:50:49
 */
public class BenzCar extends Car {
    private static final String brand = "benz";

    @Override
    public void drive() {
        proto(brand, "driving");
    }

    @Override
    public void park() {
        proto(brand, "parking");
    }

    @Override
    public void injectGas() {
        proto(brand, "injecting gas");
    }

}
