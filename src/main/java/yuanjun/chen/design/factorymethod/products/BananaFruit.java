/**  
 * @Title: BananaFruit.java   
 * @Package: yuanjun.chen.design.factorymethod.products   
 * @Description: BananaFruit  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:17:36   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: BananaFruit   
 * @Description: Banana  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:17:36  
 */
public class BananaFruit extends Fruit {
    private static final Logger logger = LogManager.getLogger(BananaFruit.class);
    @Override
    public void whatsspecial() {
        logger.info("i can make banana salad!");
    }
}
