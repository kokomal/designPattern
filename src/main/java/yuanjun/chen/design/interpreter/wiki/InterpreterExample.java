package yuanjun.chen.design.interpreter.wiki;

import java.util.Map;
import java.util.HashMap;

public class InterpreterExample {
    public static void main(final String[] args) {
        final String expression2 = "x -100 60 - +";
        final Evaluator sentence = new Evaluator(expression2);
        final Map<String, Expression> variables = new HashMap<>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        final int result = sentence.interpret(variables);
        System.out.println(result);
    }
}
