/**  
 * @Title: ObAdaptor1.java   
 * @Package: yuanjun.chen.adapter.objectadapter   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月3日 下午5:19:57   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.adapter.objectadapter;

import yuanjun.chen.adapter.common.Adaptee1;
import yuanjun.chen.adapter.common.Adaptor;

/**   
 * @ClassName: ObAdaptor1   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月3日 下午5:19:57  
 */
public class ObAdaptor1 implements Adaptor {
    Adaptee1 adpt; // 聚合，而不是继承

    public ObAdaptor1() {
        super();
        this.adpt = new Adaptee1();
    }

    @Override
    public void methodA() {
        System.out.println("-----wrapped-----");
        this.adpt.method1();
        System.out.println("-----wrapped-----");
    }

}
