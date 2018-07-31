/**  
 * @Title: IPad.java   
 * @Package: yuanjun.chen.design.abstractfactory.products   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年7月31日 下午4:01:51   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.abstractfactory.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: IPad   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年7月31日 下午4:01:51  
 */
public class IPad extends Pad {
    private static final Logger logger = LogManager.getLogger(IPad.class);
    @Override
    public void play() {
        logger.info("It's an extremely simple tool.");
    }

}
