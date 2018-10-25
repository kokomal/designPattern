package yuanjun.chen.design.bridge.shape;

import yuanjun.chen.design.bridge.draw.DrawingAPI;

public abstract class AbstractShape {
    protected DrawingAPI drawingAPI;

    protected AbstractShape(final DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw(); // low-level

    public abstract void resizeByPercentage(final double pct); // high-level
}
