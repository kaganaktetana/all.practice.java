package semester1.practice10;

interface MetricSpaceElement {
    double distanceTo(MetricSpaceElement other);

    double getNorm();
}

final class ImmutableVector3D implements MetricSpaceElement {
    private final double x;
    private final double y;
    private final double z;

    public ImmutableVector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double distanceTo(MetricSpaceElement other) {
        if (!(other instanceof ImmutableVector3D vector)) {
            throw new IllegalArgumentException(
                    "Несумісний тип елемента"
            );
        }

        double dx = x - vector.x;
        double dy = y - vector.y;
        double dz = z - vector.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

abstract class Task_35 {

    public static void main(String[] args) {
        MetricSpaceElement vector1 = new ImmutableVector3D(3, 4, 0);
        MetricSpaceElement vector2 = new ImmutableVector3D(0, 0, 0);

        System.out.println("Перший вектор: " + vector1);
        System.out.println("Норма першого вектора: " + vector1.getNorm());

        System.out.println(
                "Відстань між векторами: "
                        + vector1.distanceTo(vector2)
        );

        MetricSpaceElement[] elements = {vector1, vector2};

        for (MetricSpaceElement element : elements) {
            System.out.println("Норма елемента: " + element.getNorm());
        }
    }
}