/**
 * @Title: MainTester.java
 * @Package: yuanjun.chen.design.decorator.classic
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月8日 下午11:04:14
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.decorator.classic;

/**
 * @ClassName: MainTester
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月8日 下午11:04:14
 */
public class MainTester {
    public static void main(String[] args) {
        ConcreteComponent cmp = new ConcreteComponent();
        GongHanlinDecorator dec1 = new GongHanlinDecorator(cmp);
        TangShanDecorator dec2 = new TangShanDecorator(dec1);
        dec2.operation();
        System.out.println("--------------------");
        ConcreteComponent cmp2 = new ConcreteComponent();
        TangShanDecorator dec3 = new TangShanDecorator(cmp2);
        GongHanlinDecorator dec4 = new GongHanlinDecorator(dec3);
        dec4.operation();
    }
}
