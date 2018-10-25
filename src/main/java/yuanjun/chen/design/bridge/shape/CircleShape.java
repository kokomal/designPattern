package yuanjun.chen.design.bridge.shape;

import yuanjun.chen.design.bridge.draw.DrawingAPI;

public class CircleShape extends AbstractShape {
    private double x, y, radius;

    public CircleShape(final double x, final double y, final double radius, final DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // low-level i.e. Implementation specific
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    // high-level i.e. Abstraction specific
    public void resizeByPercentage(final double pct) {
        radius *= (1.0 + pct / 100.0);
    }
}
