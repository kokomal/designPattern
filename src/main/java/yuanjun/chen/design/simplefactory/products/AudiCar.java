/**  
 * @Title: AudiCar.java   
 * @Package: yuanjun.chen.design.simplefactory.products   
 * @Description: AudiCar具体类  
 * @author: 陈元俊     
 * @date: 2018年7月31日 上午8:38:16   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.simplefactory.products;

import yuanjun.chen.design.simplefactory.factory.CarStaticFactory;

/**   
 * @ClassName: AudiCar   
 * @Description: AudiCar具体类    
 * @author: 陈元俊 
 * @date: 2018年7月31日 上午8:38:16  
 */
public class AudiCar extends Car {
 
    @Override
    String getBrand() {
        return CarStaticFactory.CarType.AUDI.name();
    }
}
