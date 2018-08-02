/**  
 * @Title: FrenchDinner.java   
 * @Package: yuanjun.chen.design.templatemethod   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月2日 下午5:32:20   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.templatemethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: FrenchDinner   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月2日 下午5:32:20  
 */
public class FrenchDinner extends AbstractDinner {
    private static final Logger logger = LogManager.getLogger(FrenchDinner.class);
    
    @Override
    public void welcome() {
        logger.info("Bon jour~~~");
    }

    @Override
    public void appetizer() {
        logger.info("Hors-d'oeuvre Froid~~~");
    }

    @Override
    public void ordinaryDinner() {
        logger.info("Beaf Steak and Snail~~~");
    }

    @Override
    public void dessert() {
        logger.info("Cake and Cookies~~~");
    }

    @Override
    public void goodbye() {
        logger.info("Au revoir~~~");
    }

}
