package yuanjun.chen.design.bridge;

import yuanjun.chen.design.bridge.draw.DrawingAPIImpl1;
import yuanjun.chen.design.bridge.draw.DrawingAPIImpl2;
import yuanjun.chen.design.bridge.shape.CircleShape;
import yuanjun.chen.design.bridge.shape.AbstractShape;

public class BridgePattern {
    public static void main(final String[] args) {
        AbstractShape[] shapes = new AbstractShape[] {
            new CircleShape(1, 2, 3, new DrawingAPIImpl1()),
            new CircleShape(5, 7, 11, new DrawingAPIImpl2())
        };

        for (AbstractShape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}