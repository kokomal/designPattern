/**  
 * @Title: BananaFarm.java   
 * @Package: yuanjun.chen.design.factorymethod.factories   
 * @Description: BananaFarm 
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:21:42   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.factories;

import yuanjun.chen.design.factorymethod.products.BananaFruit;
import yuanjun.chen.design.factorymethod.products.Fruit;

/**   
 * @ClassName: BananaFarm   
 * @Description: BananaFarm  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:21:42  
 */
public class BananaFarm implements IFruitFarm {

    public Fruit createFruit() {
        Fruit f  = new BananaFruit();
        f.setName("Banana");
        f.setTaste("sweet");
        return f;
    }

}
