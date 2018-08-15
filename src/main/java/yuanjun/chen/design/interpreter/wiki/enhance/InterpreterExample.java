package yuanjun.chen.design.interpreter.wiki.enhance;

import java.util.Map;
import java.util.HashMap;

public class InterpreterExample {
    public static void main(final String[] args) {
        final String expression = "x -100 60 - +";
        final Evaluator sentence = new Evaluator(expression);
        final Map<String, Integer> digit_variables = new HashMap<>(); // 这里的改进是，上下文不拘泥于Number形式
        digit_variables.put("w", 5);
        digit_variables.put("x", 10);
        digit_variables.put("z", 42);
        final int result = sentence.interpret(digit_variables);
        System.out.println(result);
    }
}
