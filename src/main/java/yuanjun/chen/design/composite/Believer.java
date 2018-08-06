/**
 * @Title: Believer.java
 * @Package: yuanjun.chen.design.composite
 * @Description: 组合模式的叶子节点
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:04:51
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.composite;

import java.util.Random;

/**
 * @ClassName: Believer
 * @Description: Believer代表组合模式的叶子节点，不可能有下属成员，也不可能对下属进行操作
 * @Description: 这里采用的是安全组合模式，对leaf节点屏蔽组合的细节，这样避免了繁琐低效的
 * @Description: 抛异常编码操作 也使得 对对象的访问更加安全
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:04:51
 */
public class Believer extends Christian {

    public Believer(String name) {
        super();
        this.name = name;
    }

    @Override
    public void pray() {
        System.out.println(this.name + " prays...");
    }

    @Override
    public int taxation() {
        Random rd = new Random();
        int tax = rd.nextInt(200) + 1;
        System.out.println(this.name + " pays tax $" + tax);
        return tax;
    }
}
