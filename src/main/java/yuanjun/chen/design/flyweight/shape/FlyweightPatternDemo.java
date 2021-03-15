package yuanjun.chen.design.flyweight.shape;

/**   
 * @ClassName: FlyweightPatternDemo   
 * @Description: flyweight模式的Shape实现，对颜色的同质对象进行对象池的缓存 
 * @author: 陈元俊 
 * @date: 2018年8月15日 下午1:42:48  
 */
public class FlyweightPatternDemo {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        String color =  colors[(int) (Math.random() * colors.length)];
        System.out.println("===need color " + color);
        return color;
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
