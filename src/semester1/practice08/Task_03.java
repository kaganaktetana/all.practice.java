

package semester1.practice08;

public class Task_03 {

        public static void main(String[] args) {

            TaskCircle circle = new TaskCircle(5);

            System.out.println(circle);

            circle.setRadius(-10);

            System.out.println("Після зміни радіуса:");
            System.out.println(circle);
        }
    }

    class TaskCircle {

        private double radius;

        public TaskCircle(double radius) {
            setRadius(radius);
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            if (radius > 0) {
                this.radius = radius;
            } else {
                this.radius = 1.0;
            }
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "TaskCircle{" +
                    "radius=" + radius +
                    ", area=" + getArea() +
                    ", circumference=" + getCircumference() +
                    '}';
        }
    }
