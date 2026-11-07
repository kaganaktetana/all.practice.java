package semester1.practice08;

public class Task_23 {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3, 4);

        Point3D point3D = new Point3D(3, 4, 5);

        System.out.println(point2D);
        System.out.println("Відстань до початку координат: "
                + point2D.distanceToOrigin());

        System.out.println();

        System.out.println(point3D);
        System.out.println("Відстань до початку координат: "
                + point3D.distanceToOrigin());
    }
}

class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);

        this.z = z;
    }

    @Override
    public double distanceToOrigin() {
        return Math.sqrt(
                Math.pow(super.distanceToOrigin(), 2) + z * z
        );
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + "; " + z + ")";
    }
}