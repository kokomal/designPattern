package yuanjun.chen.design.visitor.wikidemo;

interface CarElementVisitor {
    void visit(Body body);

    void visit(Car car);

    void visit(Engine engine);

    void visit(Wheel wheel);
}
