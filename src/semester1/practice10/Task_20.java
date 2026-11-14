
package semester1.practice10;

class Vec2D {
    final double x;
    final double y;

    public Vec2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

abstract class AbstractVectorOperator {
    private final String name;

    public AbstractVectorOperator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Vec2D transform(Vec2D v);
}

interface InvertibleOperator {
    Vec2D inverseTransform(Vec2D v);
}

class Rotation2DOperator extends AbstractVectorOperator
        implements InvertibleOperator {

    private final double alpha;

    public Rotation2DOperator(double alpha) {
        super("Rotation2DOperator");
        this.alpha = alpha;
    }

    @Override
    public Vec2D transform(Vec2D v) {
        double cos = Math.cos(alpha);
        double sin = Math.sin(alpha);

        double newX = v.x * cos - v.y * sin;
        double newY = v.x * sin + v.y * cos;

        return new Vec2D(newX, newY);
    }

    @Override
    public Vec2D inverseTransform(Vec2D v) {
        double cos = Math.cos(-alpha);
        double sin = Math.sin(-alpha);

        double newX = v.x * cos - v.y * sin;
        double newY = v.x * sin + v.y * cos;

        return new Vec2D(newX, newY);
    }
}

class ProjectionXOperator extends AbstractVectorOperator {

    public ProjectionXOperator() {
        super("ProjectionXOperator");
    }

    @Override
    public Vec2D transform(Vec2D v) {
        return new Vec2D(v.x, 0);
    }
}

abstract class Task_20 {

    public static void main(String[] args) {

        Vec2D vector = new Vec2D(3, 4);

        Rotation2DOperator rotation =
                new Rotation2DOperator(Math.PI / 2);

        ProjectionXOperator projection =
                new ProjectionXOperator();

        System.out.println("Початковий вектор: " + vector);

        Vec2D rotated = rotation.transform(vector);

        System.out.println("Після повороту: " + rotated);

        Vec2D restored = rotation.inverseTransform(rotated);

        System.out.println("Після зворотного повороту: " + restored);

        Vec2D projected = projection.transform(vector);

        System.out.println("Після проєкції на OX: " + projected);
    }
}
