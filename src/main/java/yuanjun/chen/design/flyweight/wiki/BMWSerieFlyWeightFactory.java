package yuanjun.chen.design.flyweight.wiki;

import java.util.HashMap;
import java.util.Map;

public class BMWSerieFlyWeightFactory implements BMWCarFlyWeightFactory {
    private Map<Model, BMWCar> cache = new HashMap<>();

    public synchronized BMWCar getBWMModel(Model m) {
        if (!cache.containsKey(m)) {
            BMWCarFactory concreteFactory;
            switch (m) {
                case Serie2:
                    concreteFactory = new BMWSerie2Factory();
                    break;
                case Serie3:
                    concreteFactory = new BMWSerie3Factory();
                    break;
                default:
                    concreteFactory = new BMWSerie1Factory();
                    break;
            }
            cache.put(m, concreteFactory.createCar()); // 一个系列只有一个系列工厂生产的车
        }
        return cache.get(m);
    }
}
