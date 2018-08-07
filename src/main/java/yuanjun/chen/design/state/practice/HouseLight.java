/**
 * @Title: HouseLight.java
 * @Package: yuanjun.chen.design.state.practice
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:17:50
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.state.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: HouseLight
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:17:50
 */
public class HouseLight {
    private static final Logger logger = LogManager.getLogger(HouseLight.class);
    protected LightState state;

    public HouseLight(LightState state) {
        super();
        this.state = state;
    }

    public void pressButton() {
        state.change(this); // 精华所在，将上下文传入state中，进行状态切换
    }

    public void showLight() {
        logger.info("The light is " + state);
    }

}
