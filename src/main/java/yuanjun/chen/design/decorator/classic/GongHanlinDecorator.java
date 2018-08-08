/**
 * @Title: GongHanlinDecorator.java
 * @Package: yuanjun.chen.design.decorator.classic
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月8日 下午10:58:28
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.decorator.classic;

/**
 * @ClassName: GongHanlinDecorator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月8日 下午10:58:28
 */
public class GongHanlinDecorator extends AbstractDecorator implements Component {
    public GongHanlinDecorator(Component comp) {
        super(comp);
    }

    @Override
    public void operation() {
        System.out.println("麻辣鸡丝");
        super.operation();
        System.out.println("春日里开花十四五六");
    }
}
