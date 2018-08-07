/**  
 * @Title: StrategyPatternTest.java   
 * @Package: yuanjun.chen.design.strategy   
 * @Description: 策略模式测试    
 * @author: 陈元俊     
 * @date: 2018年8月7日 下午1:18:58   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.strategy;

import org.junit.Test;

/**   
 * @ClassName: StrategyPatternTest   
 * @Description: 策略模式测试  
 * @author: 陈元俊 
 * @date: 2018年8月7日 下午1:18:58  
 */
public class StrategyPatternTest {
    @Test
    public void testBilling() {
        // Prepare strategies
        BillingStrategy normalStrategy = new NormalStrategy();// 常规策略
        BillingStrategy happyHourStrategy = new HappyHourStrategy();// HappyHour策略

        Customer firstCustomer = new Customer(normalStrategy); // Context初始化的时候也要初始化设置策略

        // Normal billing
        firstCustomer.add(1.0, 1);

        // Start Happy Hour
        firstCustomer.setStrategy(happyHourStrategy); // 手动更改策略
        firstCustomer.add(1.0, 2);

        // New Customer
        Customer secondCustomer = new Customer(happyHourStrategy);
        secondCustomer.add(0.8, 1); // 0.4
        // The Customer pays
        firstCustomer.printBill(); // should be 2.0

        // End Happy Hour
        secondCustomer.setStrategy(normalStrategy);
        secondCustomer.add(1.3, 2); // 2.6
        secondCustomer.add(2.5, 1); // 2.5
        secondCustomer.printBill(); // should be 5.5
    }
}
