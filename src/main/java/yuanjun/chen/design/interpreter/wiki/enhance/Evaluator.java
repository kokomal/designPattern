package yuanjun.chen.design.interpreter.wiki.enhance;

import java.util.Map;
import java.util.Stack;

/**   
 * @ClassName: Evaluator   
 * @Description: 解释器，对逆波兰表达式进行解析入栈.  
 * @author: 陈元俊 
 * @date: 2018年8月15日 上午9:12:37  
 */
public class Evaluator implements Expression {
    private Expression syntaxTree;

    /**
     * 对表达式进行解析，递归组建表达式，最终聚合到一个表达式上
     */
    public Evaluator(final String expression) {
        final Stack<Expression> expressionStack = new java.util.Stack<>();
        // 一次遍历，一气呵成
        for (final String token : expression.split(" ")) {
            if ("+".equals(token)) {
                final Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop()); // 加法无脑pop2个
                expressionStack.push(subExpression); // 加法的结果压回栈
            } else if ("-".equals(token)) {
                // it's necessary remove first the right operand from the stack
                final Expression right = expressionStack.pop();
                // ..and after the left one
                final Expression left = expressionStack.pop();
                final Expression subExpression = new Minus(left, right); // 减法有方向
                expressionStack.push(subExpression); // 减法的结果压回栈
            } else if (isNumeric(token)) { // 一开始肯定是把值压栈
                expressionStack.push(new Constants(token));
            } else { // 变量
                expressionStack.push(new Variable(token));
            }
        }
        syntaxTree = expressionStack.pop();
    }

    public int interpret(Map<String, Integer> context) {
        return syntaxTree.interpret(context);
    }

    public static boolean isNumeric(String str) {
        char first = str.charAt(0);
        if (!Character.isDigit(first) && first != '-' && first != '+') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("222"));
        System.out.println(isNumeric("223d"));
        System.out.println(isNumeric("-999"));
    }
}
