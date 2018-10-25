package yuanjun.chen.design.bridge.draw;

public class DrawingAPIImpl2 implements DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius) {
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}
