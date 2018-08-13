/**
 * @Title: MyObserver.java
 * @Package: yuanjun.chen.design.observer.jdk
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 下午1:02:00
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: MyObserver
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 下午1:02:00
 */
public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Received response: " + arg);
    }

}
