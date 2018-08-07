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
public class ConcreteStateB implements State {
    private static final Logger logger = LogManager.getLogger(ConcreteStateB.class);

    @Override
    public String toString() {
        return "This is ConcreteStateB";
    }

    @Override
    public void handle(Context context) {
        logger.info("当前状态是 B.即将切换成A");
        context.state = new ConcreteStateA();
    }
}
