/**  
 * @Title: KiwiFarm.java   
 * @Package: yuanjun.chen.design.factorymethod.factories   
 * @Description: KiwiFarm  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:26:44   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.factories;

import yuanjun.chen.design.factorymethod.products.Fruit;
import yuanjun.chen.design.factorymethod.products.KiwiFruit;

/**   
 * @ClassName: KiwiFarm   
 * @Description: KiwiFarm  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:26:44  
 */
public class KiwiFarm implements IFruitFarm {

    public Fruit createFruit() {
        Fruit f  = new KiwiFruit();
        f.setName("Kiwi");
        f.setTaste("acid");
        return f;
    }

}
