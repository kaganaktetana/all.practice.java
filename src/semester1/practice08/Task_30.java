package semester1.practice08;

public class Task_30 {
    public static void main(String[] args) {

        Segment1D segment = new Segment1D(5);
        Square2D square = new Square2D(5);
        Cube3D cube = new Cube3D(5);

        System.out.println(segment);
        System.out.println();

        System.out.println(square);
        System.out.println("Периметр: " + square.getPerimeter());
        System.out.println("Площа: " + square.getArea());
        System.out.println();

        System.out.println(cube);
        System.out.println("Площа поверхні: " + cube.getArea());
        System.out.println("Об'єм: " + cube.getVolume());
    }
}

class Segment1D {
    protected double length;

    public Segment1D(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Відрізок: довжина = " + length;
    }
}

class Square2D extends Segment1D {

    public Square2D(double length) {
        super(length);
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public double getArea() {
        return length * length;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", квадрат: периметр = " + getPerimeter()
                + ", площа = " + getArea();
    }
}

class Cube3D extends Square2D {

    public Cube3D(double length) {
        super(length);
    }

    @Override
    public double getArea() {
        return 6 * super.getArea();
    }

    public double getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", куб: площа повної поверхні = " + getArea()
                + ", об'єм = " + getVolume();
    }
}