/**
 * 
 */
package yuanjun.chen.design.state;

/**
 * @author hp
 *
 */
public class Context {
	protected State state;

	public Context(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
    public void request()
    {
        state.handle(this);
    }
    
    public static void main(String[] args) {
    	Context context = new Context(new ConcreteStateA());
    	context.request();
    	System.out.println(context.state);
    	context.request();
    	System.out.println(context.state);
    	
	}
}
