package yuanjun.chen.design.visitor.wikidemo;

interface CarElement {
    void accept(CarElementVisitor visitor);
}
