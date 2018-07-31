/**
 * @Title: Fruit.java
 * @Package: yuanjun.chen.design.factorymethod.products
 * @Description: 抽象产品类
 * @author: 陈元俊
 * @date: 2018年7月31日 上午11:07:59
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.factorymethod.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: Fruit
 * @Description: 抽象产品类
 * @author: 陈元俊
 * @date: 2018年7月31日 上午11:07:59
 */
public abstract class Fruit {
    private static final Logger logger = LogManager.getLogger(Fruit.class);
    protected String name;
    protected String taste;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    private void selfIntro() {
        logger.info("my name is " + this.name + " and i taste " + taste);
    }
    
    public abstract void whatsspecial();
    
    public void showtime() {
        selfIntro();
        whatsspecial();
    }
}
