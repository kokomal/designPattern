/**  
 * @Title: ResumeBlock.java   
 * @Package: yuanjun.chen.design.visitor.resumedemo   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月13日 上午9:03:49   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.visitor.resumedemo;

/**   
 * @ClassName: ResumeBlock   
 * @Description:
 * @author: 陈元俊 
 * @date: 2018年8月13日 上午9:03:49  
 */
public interface ResumeBlock {
    void accept(Viewer viewer);
}
