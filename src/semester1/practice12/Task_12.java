package semester1.practice12;

import java.util.*;

public class Task_12 {

    static class BrokenPoint2D {
        private final int x;
        private final int y;

        public BrokenPoint2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class ValidPoint2D {
        private final int x;
        private final int y;

        public ValidPoint2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ValidPoint2D)) return false;

            ValidPoint2D point = (ValidPoint2D) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }
    }

    public static void main(String[] args) {
        Set<BrokenPoint2D> brokenPoints = new HashSet<>();

        brokenPoints.add(new BrokenPoint2D(0, 0));
        brokenPoints.add(new BrokenPoint2D(3, 4));
        brokenPoints.add(new BrokenPoint2D(0, 0));
        brokenPoints.add(new BrokenPoint2D(3, 4));

        Set<ValidPoint2D> validPoints = new HashSet<>();

        validPoints.add(new ValidPoint2D(0, 0));
        validPoints.add(new ValidPoint2D(3, 4));
        validPoints.add(new ValidPoint2D(0, 0));
        validPoints.add(new ValidPoint2D(3, 4));

        System.out.println("BrokenPoint2D size: "
                + brokenPoints.size());

        System.out.println("ValidPoint2D size: "
                + validPoints.size());

        System.out.println("Перевірка точки (3; 4): "
                + validPoints.contains(new ValidPoint2D(3, 4)));

        System.out.println("Valid points: " + validPoints);
    }
}
