/**
 * @Title: Expression.java
 * @Package: yuanjun.chen.design.interpreter
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月14日 下午9:34:29
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.interpreter.easy;

/**
 * @ClassName: Expression
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月14日 下午9:34:29
 */
public interface Expression {
    boolean interpret(String context);
}
