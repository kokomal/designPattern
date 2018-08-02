/**  
 * @Title: ChineseDinner.java   
 * @Package: yuanjun.chen.design.templatemethod   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月2日 下午5:27:47   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.templatemethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**   
 * @ClassName: ChineseDinner   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月2日 下午5:27:47  
 */
public class ChineseDinner extends AbstractDinner {
    private static final Logger logger = LogManager.getLogger(ChineseDinner.class);
    
    @Override
    public void welcome() {
        logger.info("有朋自远方来，不亦乐乎~~~");
    }

    @Override
    public void appetizer() {
        logger.info("腌黄瓜~~~");
    }


    @Override
    public void ordinaryDinner() {
        logger.info("米饭+宫保鸡丁+小炒肉~~~");
    }

    @Override
    public void dessert() {
        logger.info("绿豆糕~~~");
    }

    @Override
    public void goodbye() {
        logger.info("高山流水✿❉❈✲");
    }

}
