package yuanjun.chen.design.interpreter.wiki;

import java.util.Map;

public interface Expression {
    public int interpret(final Map<String, Expression> variables);
}