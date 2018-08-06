/**  
 * @Title: ObAdaptor2.java   
 * @Package: yuanjun.chen.adapter.objectadapter   
 * @Description: 针对每一个Adaptee做一个适配器，在预期的接口中，包装adaptee的行为   
 * @author: 陈元俊     
 * @date: 2018年8月3日 下午5:19:57   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.adapter.objectadapter;

import yuanjun.chen.design.adapter.common.Adaptee2;
import yuanjun.chen.design.adapter.common.Adaptor;

/**   
 * @ClassName: ObAdaptor2   
 * @Description: 针对每一个Adaptee做一个适配器，在预期的接口中，包装adaptee的行为    
 * @author: 陈元俊 
 * @date: 2018年8月3日 下午5:19:57  
 */
public class ObAdaptor2 implements Adaptor {
    Adaptee2 adpt;

    public ObAdaptor2() {
        super();
        this.adpt = new Adaptee2();
    }

    @Override
    public void methodA() {
        System.out.println("-----wrapped-----");
        this.adpt.method2();
        System.out.println("-----wrapped-----");
    }

}
