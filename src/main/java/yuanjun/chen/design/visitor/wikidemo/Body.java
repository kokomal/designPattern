package yuanjun.chen.design.visitor.wikidemo;

class Body implements CarElement {
    public void accept(final CarElementVisitor visitor) {
        visitor.visit(this);
    }
}
