
package semester1.practice10;

interface Transformable2D {

    void translate(double dx, double dy);

    void scale(double factor);
}

class BoundingBox implements Transformable2D {
    private double x;
    private double y;
    private double w;
    private double h;

    public BoundingBox(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void scale(double factor) {
        w *= factor;
        h *= factor;
    }

    @Override
    public String toString() {
        return "BoundingBox: x=" + x + ", y=" + y
                + ", w=" + w + ", h=" + h;
    }
}

class CircleRegion implements Transformable2D {
    private double x;
    private double y;
    private double r;

    public CircleRegion(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void scale(double factor) {
        r *= factor;
    }

    @Override
    public String toString() {
        return "CircleRegion: x=" + x + ", y=" + y
                + ", r=" + r;
    }
}

abstract class Task_15 {

    public static void applyGlobalTransform(
            Transformable2D[] objects,
            double dx,
            double dy,
            double scaleFactor
    ) {

        for (Transformable2D object : objects) {
            object.translate(dx, dy);
            object.scale(scaleFactor);
        }
    }

    public static void main(String[] args) {

        Transformable2D[] objects = {
                new BoundingBox(10, 20, 100, 50),
                new CircleRegion(30, 40, 15)
        };

        System.out.println("До трансформації:");

        for (Transformable2D object : objects) {
            System.out.println(object);
        }

        applyGlobalTransform(objects, 5, 10, 2);

        System.out.println();
        System.out.println("Після трансформації:");

        for (Transformable2D object : objects) {
            System.out.println(object);
        }
    }
}
