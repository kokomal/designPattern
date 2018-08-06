/**
 * 
 */
package yuanjun.chen.design.state;

/**
 * @author hp
 *
 */
public class ConcreteStateA implements State {

	@Override
	public String toString() {
		return "This is ConcreteStateA";
	}

	@Override
	public void handle(Context context) {
		System.out.println("当前状态是 A.即将切换成B");
        context.state = new ConcreteStateB();
	}
}
