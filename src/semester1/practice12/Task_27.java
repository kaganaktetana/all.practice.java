package semester1.practice12;

import java.util.*;

public class Task_27 {

    public static void main(String[] args) {

        List<AbstractShape> shapes = new ArrayList<>();

        shapes.add(new Circle("Circle 1", 3));
        shapes.add(new Circle("Circle 2", 2));
        shapes.add(new Rectangle("Rectangle 1", 4, 5));
        shapes.add(new Rectangle("Rectangle 2", 2, 3));
        shapes.add(new FixedStampSquare("Stamp 1", 5));
        shapes.add(new FixedStampSquare("Stamp 2", 2));

        System.out.println("=== SHAPES ===");

        System.out.println("Початкова кількість фігур: "
                + shapes.size());

        // Видалення фігур з площею менше 15
        Iterator<AbstractShape> iterator = shapes.iterator();

        while (iterator.hasNext()) {

            AbstractShape shape = iterator.next();

            if (shape.area() < 15.0) {
                System.out.println("Видалено: "
                        + shape.getName());

                iterator.remove();
            }
        }

        // Масштабування фігур, які підтримують Scalable
        for (AbstractShape shape : shapes) {

            if (shape instanceof Scalable sc) {

                sc.scale(1.5);

                System.out.println("Масштабовано: "
                        + shape.getName());
            }
        }

        System.out.println("\n=== РЕЗУЛЬТАТ ===");

        for (AbstractShape shape : shapes) {

            System.out.printf(
                    Locale.US,
                    "%s | Площа: %.2f%n",
                    shape.getName(),
                    shape.area()
            );
        }

        System.out.println("Залишилось фігур: "
                + shapes.size());
    }

    // Абстрактний клас
    public static abstract class AbstractShape {

        protected String name;

        public AbstractShape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double area();
    }

    // Інтерфейс масштабування
    public interface Scalable {
        void scale(double factor);
    }

    // Коло
    public static class Circle extends AbstractShape
            implements Scalable {

        private double radius;

        public Circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public void scale(double factor) {
            radius *= factor;
        }
    }

    // Прямокутник
    public static class Rectangle extends AbstractShape
            implements Scalable {

        private double width;
        private double height;

        public Rectangle(String name, double width, double height) {
            super(name);
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public void scale(double factor) {
            width *= factor;
            height *= factor;
        }
    }

    // Квадрат, який не можна масштабувати
    public static final class FixedStampSquare
            extends AbstractShape {

        private final double side;

        public FixedStampSquare(String name, double side) {
            super(name);
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }
    }
}
