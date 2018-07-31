/**  
 * @Title: OrangeFruit.java   
 * @Package: yuanjun.chen.design.factorymethod.products   
 * @Description: Orange 
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:20:25   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: OrangeFruit   
 * @Description: Orange  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:20:25  
 */
public class OrangeFruit extends Fruit {
    private static final Logger logger = LogManager.getLogger(OrangeFruit.class);
    @Override
    public void whatsspecial() {
        logger.info("i can make orange juice!");
    }

}
