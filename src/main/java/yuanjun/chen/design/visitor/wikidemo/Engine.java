package yuanjun.chen.design.visitor.wikidemo;

class Engine implements CarElement {
    public void accept(final CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
