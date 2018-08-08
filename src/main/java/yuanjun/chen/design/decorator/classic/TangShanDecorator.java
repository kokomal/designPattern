/**  
 * @Title: TangShanDecorator.java   
 * @Package: yuanjun.chen.design.decorator.classic   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月8日 下午11:00:07   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.decorator.classic;

/**   
 * @ClassName: TangShanDecorator   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月8日 下午11:00:07  
 */
public class TangShanDecorator extends AbstractDecorator implements Component {
    public TangShanDecorator(Component comp) {
        super(comp);
    }

    @Override
    public void operation() {
        System.out.println("河北梆子开始");
        super.operation();
        System.out.println("六呀六呀春打六九头");
    }
}
