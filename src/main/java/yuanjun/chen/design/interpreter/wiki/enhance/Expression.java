package yuanjun.chen.design.interpreter.wiki.enhance;

import java.util.Map;

public interface Expression {
    int interpret(final Map<String, Integer> variables);
}