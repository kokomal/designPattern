package yuanjun.chen.design.interpreter.easy;

public class InterpreterPatternDemo {
    /** 规则：Robert 和 John 是男性. */
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John"); // 语法子规则
        return new OrExpression(robert, john);
    }

    /** 规则：Julie 是一个已婚的女性. */
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Married John is male? " + isMale.interpret("Married John"));
        
        System.out.println("Julie is a married woman? " + isMarriedWoman.interpret("Married Julie"));
        System.out.println("Married John is a MarriedWoman? " + isMarriedWoman.interpret("Married John"));
    }
}
