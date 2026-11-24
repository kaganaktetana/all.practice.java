
package semester1.practice12;

import java.util.*;

final class IntVector2D {
    private final int dx;
    private final int dy;

    public IntVector2D(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dotProduct(IntVector2D other) {
        return dx * other.dx + dy * other.dy;
    }

    public double norm() {
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntVector2D)) return false;
        IntVector2D v = (IntVector2D) o;
        return dx == v.dx && dy == v.dy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dx, dy);
    }

    @Override
    public String toString() {
        return "(" + dx + ", " + dy + ")";
    }
}

public class Task_16 {
    public static void main(String[] args) {

        IntVector2D[] vectors = {
                new IntVector2D(1, 0),
                new IntVector2D(0, 1),
                new IntVector2D(2, 0),
                new IntVector2D(0, 2),
                new IntVector2D(1, 1),
                new IntVector2D(-1, 1),
                new IntVector2D(1, 0)
        };

        Set<IntVector2D> set = new HashSet<>(
                Arrays.asList(vectors));

        System.out.println("Унікальні вектори: " + set.size());
        System.out.println(set);

        List<IntVector2D> list = new ArrayList<>(set);

        System.out.println("\nПерпендикулярні пари:");

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                IntVector2D a = list.get(i);
                IntVector2D b = list.get(j);

                if (a.norm() != 0 && b.norm() != 0
                        && a.dotProduct(b) == 0) {

                    System.out.println(a + " ⟂ " + b);
                }
            }
        }
    }
}
