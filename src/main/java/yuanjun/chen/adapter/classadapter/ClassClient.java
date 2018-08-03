/**
 * @Title: Client.java
 * @Package: yuanjun.chen.adapter.classadapter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月3日 下午4:36:28
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.adapter.classadapter;

import yuanjun.chen.adapter.common.Adaptor;

/**
 * @ClassName: Client
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月3日 下午4:36:28
 */
public class ClassClient {

    public void workWithAdaptor(Adaptor adp) {
        adp.methodA();
    }

    public static void main(String[] args) {
        ClassClient c = new ClassClient();
        c.workWithAdaptor(new ClassAdaptor1());
        c.workWithAdaptor(new ClassAdaptor2());
    }
}
