package yuanjun.chen.design.interpreter.wiki;

import java.util.Map;

/**   
 * @ClassName: Variable   
 * @Description: 变量 
 * @author: 陈元俊 
 * @date: 2018年8月15日 上午9:16:35  
 */
public class Variable implements Expression {
    private String name;

    public Variable(final String name) {
        this.name = name;
    }

    public int interpret(final Map<String, Expression> variables) {
        if (null == variables.get(name))
            return 0; // Either return new Number(0).
        return variables.get(name).interpret(variables); // 关键，根据变量名找到value，Number
    }
}
