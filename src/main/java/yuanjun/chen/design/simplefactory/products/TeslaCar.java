/**  
 * @Title: TeslaCar.java   
 * @Package: yuanjun.chen.design.simplefactory.products   
 * @Description: TeslaCar具体类  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午8:38:25   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.simplefactory.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yuanjun.chen.design.simplefactory.CarFactory;

/**   
 * @ClassName: TeslaCar   
 * @Description: TeslaCar具体类  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午8:38:25  
 */
public class TeslaCar extends Car {
    private static final Logger logger = LogManager.getLogger(TeslaCar.class);
    @Override
    String getBrand() {
        return CarFactory.CarType.TESLA.name();
    }
    
    @Override
    public void injectGas() {
        logger.info(getBrand() + " no gas, just electric!!!");
    }
}
