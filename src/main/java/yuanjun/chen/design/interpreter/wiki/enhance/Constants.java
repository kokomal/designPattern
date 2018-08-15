/**  
 * @Title: Constants.java   
 * @Package: yuanjun.chen.design.interpreter.wiki   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月15日 上午9:01:17   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.interpreter.wiki.enhance;

import java.util.Map;

/**   
 * @ClassName: Constants   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月15日 上午9:01:17  
 */
public class Constants implements Expression {
    private String name;

    public Constants(final String name) {
        this.name = name;
    }
   
    @Override
    public int interpret(Map<String, Integer> variables) {
        return Integer.parseInt(name);
    }

}
