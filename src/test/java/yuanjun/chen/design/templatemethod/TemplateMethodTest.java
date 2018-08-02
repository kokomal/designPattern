/**  
 * @Title: TemplateMethodTest.java   
 * @Package: yuanjun.chen.design.templatemethod   
 * @Description: 模板方法测试    
 * @author: 陈元俊     
 * @date: 2018年8月2日 下午5:38:05   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.templatemethod;

import org.junit.Test;

/**   
 * @ClassName: TemplateMethodTest   
 * @Description: 模板方法测试  
 * @author: 陈元俊 
 * @date: 2018年8月2日 下午5:38:05  
 */
public class TemplateMethodTest {
    @Test
    public void testDinner1() {
        AbstractDinner dinner = new ChineseDinner();
        dinner.normalProcedure();
    }
    
    @Test
    public void testDinner2() {
        AbstractDinner dinner = new FrenchDinner();
        dinner.normalProcedure();
    }
}
