package yuanjun.chen.design.flyweight.wiki;

public class BMWSerie1Factory implements BMWCarFactory {
    @Override
    public BMWCar createCar() {
        return new BMWSerie1();
    }
}
