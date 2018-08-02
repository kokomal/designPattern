/**  
 * @Title: AbstractDinner.java   
 * @Package: yuanjun.chen.design.templatemethod   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月1日 下午6:16:17   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.templatemethod;

/**   
 * @ClassName: AbstractDinner   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月1日 下午6:16:17  
 */
public abstract class AbstractDinner {
    public abstract void welcome();
    
    public abstract void appetizer();
    
    public abstract void ordinaryDinner();
    
    public abstract void dessert();
    
    public abstract void goodbye();
    
    public void normalProcedure() {
        welcome();
        appetizer();
        ordinaryDinner();
        dessert();
        goodbye();
    }
}
