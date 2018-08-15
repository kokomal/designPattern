package yuanjun.chen.design.flyweight.wiki;

public class BMWSerie2Factory implements BMWCarFactory {
    @Override
    public BMWCar createCar() {
        return new BMWSerie2();
    }
}
