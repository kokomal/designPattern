package yuanjun.chen.design.flyweight.shape;

import java.util.HashMap;

/**   
 * @ClassName: ShapeFactory   
 * @Description: 形状工厂，对形状进行库存池化管理  
 * @author: 陈元俊 
 * @date: 2018年8月15日 下午1:47:41  
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            System.out.println("---the shape in color " + color + " is not in the archive.");
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("---finished creating circle of color : " + color);
        } else {
            System.out.println("~~~fetch the shape in " + color + " that already exists");
        }
        
        return circle;
    }
}
