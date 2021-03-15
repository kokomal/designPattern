package yuanjun.chen.design.flyweight.wiki;
public interface BMWCarFlyWeightFactory {
    enum Model {
        Serie1, Serie2, Serie3
    }

    BMWCar getBWMModel(Model m);
}