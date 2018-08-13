/**
 * @Title: InterestPublisher.java
 * @Package: yuanjun.chen.design.observer.bank
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午11:25:24
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.observer.bank;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * @ClassName: InterestPublisher
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午11:25:24
 */
public class CentralBank extends Observable{
    private Set<CommercialBank> obs = new HashSet<>();
    private Double interest;

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public CentralBank(Double interest) {
        this.interest = interest;
    }

    public void registerBank(CommercialBank bank) {
        obs.add(bank);
    }

    public void removeBank(CommercialBank bank) {
        obs.remove(bank);
    }

    public void notifyInterests() {
        for (CommercialBank bank : obs) {
            bank.notifyInterest(this.interest);
        }
    }

    public void notifyInterestsUsingJdk() {
        setChanged(); // 一定要设置为changed
        notifyObservers(this.interest); // 通知，添加/删除观察者，都在Observable里面有实现
    }
    public void registerBankUsingJdk(CommercialBank bank) {
        addObserver(bank);
    }

    public void removeBankUsingJdk(CommercialBank bank) {
        deleteObserver(bank);
    }
    
    public static void main(String[] args) {
    }
}
