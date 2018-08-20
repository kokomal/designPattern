/**
 * @Title: Purse.java
 * @Package: yuanjun.chen.design.prototype.classic
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月20日 下午4:14:21
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.prototype;

/**
 * @ClassName: Purse
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月20日 下午4:14:21
 */
public class Purse {
    private int money;
    private String owner;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Purse [money=" + money + ", owner=" + owner + "]";
    }

}
