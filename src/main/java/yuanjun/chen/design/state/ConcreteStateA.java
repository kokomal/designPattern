/**
 * 
 */
package yuanjun.chen.design.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author hp
 *
 */
public class ConcreteStateA implements State {
    private static final Logger logger = LogManager.getLogger(ConcreteStateA.class);

    @Override
    public String toString() {
        return "This is ConcreteStateA";
    }

    @Override
    public void handle(Context context) {
        logger.info("当前状态是 A.即将切换成B");
        context.state = new ConcreteStateB();
    }
}
