/**
 * @Title: StaticElectronicFatory.java
 * @Package: yuanjun.chen.design.abstractfactory.factories
 * @Description: 工厂的静态工厂
 * @author: 陈元俊
 * @date: 2018年7月31日 下午4:22:29
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.abstractfactory.factories;

/**
 * @ClassName: StaticElectronicFatory
 * @Description: 工厂的静态工厂
 * @author: 陈元俊
 * @date: 2018年7月31日 下午4:22:29
 */
public class StaticElectronicFatory {
    
    public static final String SAMSUNG = "Samsung";
    public static final String APPLE = "Apple";

    public static IElectronicsFactory creatFactoryByName(String name) throws Exception {
        if (APPLE.equalsIgnoreCase(name)) {
            return new AppleFactory();
        } else if (SAMSUNG.equalsIgnoreCase(name)) {
            return new SamsungFactory();
        }
        throw new Exception("no factory named " + name);
    }
}
