/**  
 * @Title: LightState.java   
 * @Package: yuanjun.chen.design.state.practice   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月7日 上午8:18:10   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.state.practice;

/**   
 * @ClassName: LightState   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月7日 上午8:18:10  
 */
public interface LightState {
    void change(HouseLight light);
}
