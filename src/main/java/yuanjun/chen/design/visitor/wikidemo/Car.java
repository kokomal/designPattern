package yuanjun.chen.design.visitor.wikidemo;

/**
 * Car是所有部件的聚合体，同样也实现CarElement接口的accept方法
 */
public class Car implements CarElement {
    final CarElement[] elements; // 不能把自己也包含进去，否则死循环了

    public Car() {
        this.elements = new CarElement[] {new Wheel("front left"), new Wheel("front right"), new Wheel("back left"),
                new Wheel("back right"), new Body(), new Engine()};
    }

    public void accept(final CarElementVisitor visitor) {
        for (CarElement elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}
