/**  
 * @Title: ConcreteAdaptor1.java   
 * @Package: yuanjun.chen.adapter.classadapter   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月3日 下午4:44:21   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.adapter.classadapter;

import yuanjun.chen.design.adapter.common.Adaptee2;
import yuanjun.chen.design.adapter.common.Adaptor;

/**   
 * @ClassName: ConcreteAdaptor1   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月3日 下午4:44:21  
 */
public class ClassAdaptor2 extends Adaptee2 implements Adaptor {

    @Override
    public void methodA() {
        System.out.println("---begin transform---");
        method2();
        System.out.println("---end transform---");
    }

}
