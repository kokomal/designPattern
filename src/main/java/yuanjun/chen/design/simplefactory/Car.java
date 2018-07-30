/**  
 * @Title: Car.java   
 * @Package: yuanjun.chen.design.simplefactory   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年7月30日 下午5:48:28   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.simplefactory;

/**   
 * @ClassName: Car   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年7月30日 下午5:48:28  
 */
public abstract class Car {
    public abstract void drive();
    public abstract void park();
    public abstract void injectGas();
    public void proto(String brand, String action) {
        System.out.println(brand + " is " + action);
    }
}
