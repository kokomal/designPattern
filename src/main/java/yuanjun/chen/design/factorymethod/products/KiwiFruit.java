/**  
 * @Title: KiwiFruit.java   
 * @Package: yuanjun.chen.design.factorymethod.products   
 * @Description: KiwiFruit 
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:15:58   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: KiwiFruit   
 * @Description: KiwiFruit   
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:15:58  
 */
public class KiwiFruit extends Fruit {
    private static final Logger logger = LogManager.getLogger(KiwiFruit.class);
    @Override
    public void whatsspecial() {
        logger.info("i can make kiwi jam!");
    }
}
