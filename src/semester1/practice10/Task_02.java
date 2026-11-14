
package semester1.practice10;

abstract class Shape2D {

    public abstract double getArea();

    public abstract double getPerimeter();
}

class CircleShape extends Shape2D {
    private final double r;

    public CircleShape(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }
}

class RectangleShape extends Shape2D {
    private final double a;
    private final double b;

    public RectangleShape(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }
}

class EquilateralTriangleShape extends Shape2D {
    private final double a;

    public EquilateralTriangleShape(double a) {
        this.a = a;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) / 4 * a * a;
    }

    @Override
    public double getPerimeter() {
        return 3 * a;
    }
}

public class Task_02 {

    public static Shape2D findMaxAreaShape(Shape2D[] shapes) {

        if (shapes == null || shapes.length == 0) {
            return null;
        }

        Shape2D maxShape = shapes[0];

        for (Shape2D shape : shapes) {
            if (shape.getArea() > maxShape.getArea()) {
                maxShape = shape;
            }
        }

        return maxShape;
    }

    public static void main(String[] args) {

        Shape2D[] shapes = {
                new CircleShape(5),
                new RectangleShape(4, 8),
                new EquilateralTriangleShape(10)
        };

        for (Shape2D shape : shapes) {
            System.out.println("Площа: " + shape.getArea());
            System.out.println("Периметр: " + shape.getPerimeter());
            System.out.println();
        }

        Shape2D maxShape = findMaxAreaShape(shapes);

        System.out.println("Найбільша площа: " + maxShape.getArea());
        System.out.println("Периметр цієї фігури: " + maxShape.getPerimeter());
    }
}
