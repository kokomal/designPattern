/**
 * @Title: LightOnEnum.java
 * @Package: yuanjun.chen.design.state.practice
 * @Description: 枚举继承状态接口，实现状态的切换
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:25:14
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.state.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: LightOnEnum
 * @Description: 枚举继承状态接口，实现状态的切换，略别扭，因为枚举应该是公用的，不应该混入上下文的切换逻辑中
 *               statePattern的实质，是把多个状态切换的if-else展开到各个状态的切换的多态方法中进行扩展
 *               这个practice却反其道行之，专门将状态的所有类型浓缩进了一个枚举，可以说各有利弊
 * @author: 陈元俊
 * @date: 2018年8月7日 上午8:25:14
 */
public enum LightOnEnum implements LightState {
    LightOn {
        @Override
        public void change(HouseLight light) {
            logger.info("on--->off");
            light.state = LightOff;
        }
    },
    LightOff {
        @Override
        public void change(HouseLight light) {
            logger.info("off--->on");
            light.state = LightOn;
        }
    };
    private static final Logger logger = LogManager.getLogger(LightOnEnum.class);

}
