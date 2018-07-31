/**  
 * @Title: ElectronicFactoryTest.java   
 * @Package: yuanjun.chen.design.abstractfactory   
 * @Description: 抽象工厂的测试类    
 * @author: 陈元俊     
 * @date: 2018年7月31日 下午4:10:42   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.abstractfactory;

import org.junit.Test;
import yuanjun.chen.design.abstractfactory.factories.AppleFactory;
import yuanjun.chen.design.abstractfactory.factories.IElectronicsFactory;
import yuanjun.chen.design.abstractfactory.factories.SamsungFactory;
import yuanjun.chen.design.abstractfactory.factories.StaticElectronicFatory;
import yuanjun.chen.design.abstractfactory.products.CellPhone;
import yuanjun.chen.design.abstractfactory.products.Pad;

/**   
 * @ClassName: ElectronicFactoryTest   
 * @Description: 抽象工厂的测试类   
 * @author: 陈元俊 
 * @date: 2018年7月31日 下午4:10:42  
 */
public class ElectronicFactoryTest {
    @Test
    public void testElectronicFactory1() {
        IElectronicsFactory factory = new AppleFactory();
        Pad pad = factory.createPad();
        pad.play();
        
        CellPhone phone = factory.createCellPhone();
        phone.ring();
    }
    
    @Test
    public void testElectronicFactory2() {
        IElectronicsFactory factory = new SamsungFactory();
        Pad pad = factory.createPad();
        pad.play();
        
        CellPhone phone = factory.createCellPhone();
        phone.ring();
    }
    
    @Test
    public void testElectronicFactory3() throws Exception {
        IElectronicsFactory factory = StaticElectronicFatory.creatFactoryByName(StaticElectronicFatory.SAMSUNG);
        Pad pad = factory.createPad();
        pad.play();
        
        CellPhone phone = factory.createCellPhone();
        phone.ring();
    }
}
