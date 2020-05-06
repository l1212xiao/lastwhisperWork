package com.lyx.designPattern.flyweight;

/**
 * @author lvyunxiao
 * @classname FlyweightPatternDemo
 * @description FlyweightPatternDemo
 * @date 2020/4/30
 *
 * https://www.runoob.com/design-pattern/flyweight-pattern.html
 *
 * 享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，
 * 它提供了减少对象数量从而改善应用所需的对象结构的方式。
 *
 * 享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。
 * 我们将通过创建 5 个对象来画出 20 个分布于不同位置的圆来演示这种模式。由于只有 5 种可用的颜色，
 * 所以 color 属性被用来检查现有的 Circle 对象。
 *
 * 我们将创建一个 Shape 接口和实现了 Shape 接口的实体类 Circle。下一步是定义工厂类 ShapeFactory。
 * ShapeFactory 有一个 Circle 的 HashMap，其中键名为 Circle 对象的颜色。
 * 无论何时接收到请求，都会创建一个特定颜色的圆。ShapeFactory 检查它的 HashMap 中的 circle 对象，
 * 如果找到 Circle 对象，则返回该对象，否则将创建一个存储在 hashmap 中以备后续使用的新对象，并把该对象返回到客户端。
 * FlyWeightPatternDemo，我们的演示类使用 ShapeFactory 来获取 Shape 对象。
 * 它将向 ShapeFactory 传递信息（red / green / blue/ black / white），以便获取它所需对象的颜色。
 */
public class FlyweightPatternDemo {
    private static final String COLORS[] =
            {"Red", "Green", "Blue", "White", "Black"};

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
        return COLORS[(int) (Math.random() * COLORS.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
