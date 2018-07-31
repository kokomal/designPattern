/**  
 * @Title: CarFactoryTest.java   
 * @Package: yuanjun.chen.design.simplefactory   
 * @Description: 简单静态工厂模式测试   
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午8:30:17   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.simplefactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import yuanjun.chen.design.simplefactory.factory.CarStaticFactory;
import yuanjun.chen.design.simplefactory.factory.CarStaticFactory.CarType;
import yuanjun.chen.design.simplefactory.products.Car;

/**   
 * @ClassName: CarFactoryTest   
 * @Description: 简单静态工厂模式测试  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午8:30:17  
 */
public class CarStaticFactoryTest {
    private static final Logger logger = LogManager.getLogger(CarStaticFactoryTest.class);
    
    @Test
    public void testCarFactory() {
        Car x = CarStaticFactory.generateOneCar(CarType.BENZ);
        x.drive();
        x.injectGas();
        x.park();
        logger.info("--------------------------------------");
        Car y = CarStaticFactory.generateOneCar(CarType.TESLA);
        y.park();
        y.drive();
        y.injectGas();
    }
}
