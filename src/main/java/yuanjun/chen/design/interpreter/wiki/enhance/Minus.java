package yuanjun.chen.design.interpreter.wiki.enhance;

import java.util.Map;

public class Minus implements Expression {
    Expression leftOperand;
    Expression rightOperand;

    public Minus(final Expression left, final Expression right) {
        leftOperand = left;
        rightOperand = right;
    }

    public int interpret(final Map<String, Integer> variables) {
        return leftOperand.interpret(variables) - rightOperand.interpret(variables);
    }
}
