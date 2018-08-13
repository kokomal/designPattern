/**
 * @Title: ObserverPatternTest.java
 * @Package: yuanjun.chen.design.observer
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 下午12:56:53
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.observer;

import java.util.Observer;
import org.junit.Test;
import yuanjun.chen.design.observer.bank.CentralBank;
import yuanjun.chen.design.observer.bank.CommercialBank;
import yuanjun.chen.design.observer.jdk.EventSource;
import yuanjun.chen.design.observer.jdk.MyObserver;

/**
 * @ClassName: ObserverPatternTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 下午12:56:53
 */
public class ObserverPatternTest {

    @Test
    public void wikiObTest() {
        EventSource eventSource = new EventSource();
        Observer o1 = new MyObserver();
        Observer o2 = new MyObserver();
        Observer o3 = new MyObserver();
        eventSource.addObserver(o1);
        eventSource.addObserver(o2);
        eventSource.addObserver(o3);
        Thread t1 = new Thread(eventSource);
        t1.start();
        try {
            Thread.sleep(4000); // 执行4s后停止
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        eventSource.setStop(true);
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void bankInterestTest() {
        CentralBank central = new CentralBank(8.0);
        CommercialBank cmb = new CommercialBank("CMB");
        CommercialBank abc = new CommercialBank("ABC");
        CommercialBank hxb = new CommercialBank("HXB");
        central.registerBank(cmb);
        central.registerBank(abc);
        central.registerBank(hxb);
        central.notifyInterests();
        System.out.println("--------------------");
        central.removeBank(abc); // 将abc除名
        central.setInterest(10.0); // 重新设置利率
        central.notifyInterests();
        System.out.println("--------------------");
        abc.showLocalInterest(); // abc仍然是旧的8.0利率
        
        System.out.println("---------------------------------JDK---------------------------------");
        
        CentralBank central2 = new CentralBank(7.2); // 采用jdk内置的Observer接口和Observable类实现
        CommercialBank cmb2 = new CommercialBank("CMB"); // 注意改变状态通知时要手动置setChanged!!!
        CommercialBank abc2 = new CommercialBank("ABC");
        CommercialBank hxb2 = new CommercialBank("HXB");
        central2.registerBankUsingJdk(cmb2);
        central2.registerBankUsingJdk(abc2);
        central2.registerBankUsingJdk(hxb2);
        central2.notifyInterestsUsingJdk();
        System.out.println("--------------------");
        central2.removeBankUsingJdk(abc2);
        central2.setInterest(11.3);
        central2.notifyInterestsUsingJdk();
        System.out.println("--------------------");
        abc2.showLocalInterest();
    }
}
