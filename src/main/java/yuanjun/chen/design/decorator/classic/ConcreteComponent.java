/**  
 * @Title: ConcreteComponent.java   
 * @Package: yuanjun.chen.design.decorator.classic   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月8日 下午10:56:30   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.decorator.classic;

/**   
 * @ClassName: ConcreteComponent   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月8日 下午10:56:30  
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("I am an ordinary guy, really.");
    }
}
