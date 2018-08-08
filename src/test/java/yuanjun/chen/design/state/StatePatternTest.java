/**
 * @Title: StatePatternTest.java
 * @Package: yuanjun.chen.design.state
 * @Description: 2种state模式的测试
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:46:05
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import yuanjun.chen.design.state.practice.HouseLight;
import yuanjun.chen.design.state.practice.LightOnEnum;

/**
 * @ClassName: StatePatternTest
 * @Description: 2种state模式的测试
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:46:05
 */
public class StatePatternTest {
    private static final Logger logger = LogManager.getLogger(StatePatternTest.class);

    @Test
    public void testClassicStatePattern() {
        Context context = new Context(new ConcreteStateA());
        context.request();
        logger.info(context.state);
        context.request();
        logger.info(context.state);
    }

    @Test
    public void testLight() {
        HouseLight light = new HouseLight(LightOnEnum.LightOff); // off
        light.pressButton(); // off--->on
        light.showLight(); // on
        light.pressButton(); // on--->off
        light.showLight(); // off
    }

}
