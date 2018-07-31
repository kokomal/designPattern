/**  
 * @Title: IFruitFactory.java   
 * @Package: yuanjun.chen.design.factorymethod   
 * @Description: 抽象水果工厂  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:13:16   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod.factories;

import yuanjun.chen.design.factorymethod.products.Fruit;

/**   
 * @ClassName: IFruitFactory   
 * @Description: 抽象水果工厂  
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:13:16  
 */
public interface IFruitFarm {
    Fruit createFruit();
}
