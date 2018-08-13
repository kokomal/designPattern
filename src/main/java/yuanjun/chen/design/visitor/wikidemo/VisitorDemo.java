package yuanjun.chen.design.visitor.wikidemo;

public class VisitorDemo {
    public static void main(final String[] args) {
        final Car car = new Car();

        car.accept(new CarElementPrintVisitor());
        System.out.println("---------------------------------");
        car.accept(new CarElementDoVisitor());
        System.out.println("---------------------------------");
        new CarElementDoVisitor().visit(car);
    }
}
