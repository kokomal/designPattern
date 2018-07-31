/**  
 * @Title: AppleFactpry.java   
 * @Package: yuanjun.chen.design.abstractfactory.factories   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年7月31日 下午4:06:30   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.abstractfactory.factories;

import yuanjun.chen.design.abstractfactory.products.CellPhone;
import yuanjun.chen.design.abstractfactory.products.IPad;
import yuanjun.chen.design.abstractfactory.products.IPhone;
import yuanjun.chen.design.abstractfactory.products.Pad;

/**   
 * @ClassName: AppleFactpry   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年7月31日 下午4:06:30  
 */
public class AppleFactory implements IElectronicsFactory {

    public Pad createPad() {
        return new IPad();
    }

    public CellPhone createCellPhone() {
        return new IPhone();
    }

}
