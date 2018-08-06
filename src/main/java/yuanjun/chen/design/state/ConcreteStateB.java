/**
 * 
 */
package yuanjun.chen.design.state;

/**
 * @author hp
 *
 */
public class ConcreteStateB implements State {

	@Override
	public String toString() {
		return "This is ConcreteStateB";
	}
	
	@Override
	public void handle(Context context) {
		System.out.println("当前状态是 B.即将切换成A");
        context.state = new ConcreteStateA();
	}
}
