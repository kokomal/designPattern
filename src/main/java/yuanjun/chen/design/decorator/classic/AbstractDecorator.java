/**  
 * @Title: AbstractDecorator.java   
 * @Package: yuanjun.chen.design.decorator.classic   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月8日 下午10:57:25   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.decorator.classic;

/**   
 * @ClassName: AbstractDecorator   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月8日 下午10:57:25  
 */
public abstract class AbstractDecorator implements Component {
    private Component comp;
        public AbstractDecorator(Component comp) {
        this.comp = comp;
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    @Override
    public void operation() {
        this.comp.operation();
    }
}
