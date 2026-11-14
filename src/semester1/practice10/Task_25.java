
package semester1.practice10;

abstract class Task25Shape2D {
}

class CircleShapet extends Task25Shape2D {
    private final double radius;

    public CircleShapet(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }
}

class RectangleShapet extends Task25Shape2D {
    private final double width;
    private final double height;

    public RectangleShapet(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public boolean isSquare() {
        return width == height;
    }
}

abstract class Task_25 {

    public static void main(String[] args) {

        Task25Shape2D[] shapes = {
                new CircleShapet(5),
                new RectangleShapet(4, 8),
                new RectangleShapet(6, 6),
                new CircleShapet(3)
        };

        for (Task25Shape2D shape : shapes) {

            if (shape instanceof CircleShapet c) {
                System.out.println("Коло:");
                System.out.println("Діаметр: " + c.getDiameter());

            } else if (shape instanceof RectangleShapet r) {
                System.out.println("Прямокутник:");
                System.out.println("Діагональ: " + r.getDiagonal());
                System.out.println("Це квадрат: " + r.isSquare());
            }

            System.out.println();
        }

        Task25Shape2D shape = null;

        System.out.println("null instanceof Task25Shape2D: "
                + (shape instanceof Task25Shape2D));
    }
}