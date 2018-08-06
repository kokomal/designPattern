/**  
 * @Title: ObClient.java   
 * @Package: yuanjun.chen.adapter.objectadapter   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月3日 下午5:00:49   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.adapter.objectadapter;

import yuanjun.chen.design.adapter.common.Adaptor;

/**   
 * @ClassName: ObClient   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月3日 下午5:00:49  
 */
public class ObClient {
    private Adaptor adp;

    public void setAdaptor(Adaptor adp) {
        this.adp = adp;
    }
    
    public void doWork() {
        this.adp.methodA();
    }
    
    public static void main(String[] args) {
        ObClient cli = new ObClient();
        cli.setAdaptor(new ObAdaptor1());
        cli.doWork();
    }
    
}
