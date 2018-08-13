package yuanjun.chen.design.visitor.wikidemo;

public interface CarElement {
    void accept(CarElementVisitor visitor);
}
