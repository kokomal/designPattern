/**
 * @Title: BankAsOb.java
 * @Package: yuanjun.chen.design.observer.bank
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午11:25:44
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.observer.bank;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName: BankAsOb
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午11:25:44
 */
public class CommercialBank implements Observer{
    private final String bankName;

    private Double localInterest;

    public CommercialBank(String bankName) {
        this.bankName = bankName;
    }

    public void notifyInterest(final Double interest) {
        this.localInterest = interest;
        showLocalInterest();
    }

    public void showLocalInterest() {
        System.out.println(this.bankName + " has local interest of " + this.localInterest);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((bankName == null) ? 0 : bankName.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommercialBank other = (CommercialBank) obj;
        if (bankName == null) {
            if (other.bankName != null) {
                return false;
            }
        } else if (!bankName.equals(other.bankName)) {
            return false;
        }
        return true;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.localInterest = (Double) arg;
        showLocalInterest();
    }
}
