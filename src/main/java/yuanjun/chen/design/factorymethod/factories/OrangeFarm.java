/**
 * @Title: OrangeFarm.java
 * @Package: yuanjun.chen.design.factorymethod.factories
 * @Description: OrangeFarm
 * @author: 陈元俊
 * @date: 2018年7月31日 上午11:27:42
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.factorymethod.factories;

import yuanjun.chen.design.factorymethod.products.Fruit;
import yuanjun.chen.design.factorymethod.products.OrangeFruit;

/**
 * @ClassName: OrangeFarm
 * @Description: OrangeFarm
 * @author: 陈元俊
 * @date: 2018年7月31日 上午11:27:42
 */
public class OrangeFarm implements IFruitFarm {

    public Fruit createFruit() {
        Fruit f = new OrangeFruit();
        f.setName("Orange");
        f.setTaste("sweet and acid");
        return f;
    }

}
