/**  
 * @Title: IElectronicsFactory.java   
 * @Package: yuanjun.chen.design.abstractfactory.factories   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年7月31日 下午4:03:28   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.abstractfactory.factories;

import yuanjun.chen.design.abstractfactory.products.CellPhone;
import yuanjun.chen.design.abstractfactory.products.Pad;

/**   
 * @ClassName: IElectronicsFactory   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年7月31日 下午4:03:28  
 */
public interface IElectronicsFactory {
    Pad createPad();
    CellPhone createCellPhone();
}
