/**  
 * @Title: FruitFarmTest.java   
 * @Package: yuanjun.chen.design.factorymethod   
 * @Description: 工厂方法测试  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午11:29:56   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.factorymethod;

import org.junit.Test;
import yuanjun.chen.design.factorymethod.factories.BananaFarm;
import yuanjun.chen.design.factorymethod.factories.IFruitFarm;
import yuanjun.chen.design.factorymethod.factories.KiwiFarm;
import yuanjun.chen.design.factorymethod.factories.OrangeFarm;
import yuanjun.chen.design.factorymethod.products.Fruit;

/**   
 * @ClassName: FruitFarmTest   
 * @Description: 工厂方法测试    
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午11:29:56  
 */
public class FruitFarmTest {
    @Test
    public void testFruitFarm() {
        IFruitFarm farm1 = new KiwiFarm();
        Fruit fruit1 = farm1.createFruit();
        fruit1.showtime();
        
        IFruitFarm farm2 = new OrangeFarm();
        Fruit fruit2 = farm2.createFruit();
        fruit2.showtime();
        
        IFruitFarm farm3 = new BananaFarm();
        Fruit fruit3 = farm3.createFruit();
        fruit3.showtime();
    }
    
    @Test
    public void testFruitFarmReflective() throws Exception {
        Fruit fruit1 = extractFruitFromName("Banana");
        fruit1.showtime();
    }
    
    public Fruit extractFruitFromName(String name) throws Exception {
        IFruitFarm addFactory = (IFruitFarm) Class.forName("yuanjun.chen.design.factorymethod.factories." + name + "Farm").newInstance();
        return addFactory.createFruit();
    }
}
