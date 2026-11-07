package semester1.practice08;

public class Task_35 {
    public static void main(String[] args) {

        LinearFunction linear = new LinearFunction(2, 3);

        QuadraticFunction quadratic =
                new QuadraticFunction(1, 2, 3);

        double x = 2;

        System.out.println(linear);
        System.out.println("Значення при x = " + x
                + ": " + linear.evaluate(x));

        System.out.println();

        System.out.println(quadratic);

        System.out.println("Значення при x = " + x
                + ": " + quadratic.evaluate(x));

        System.out.println("Координата вершини параболи x0: "
                + quadratic.getVertexX());
    }
}

class LinearFunction {
    protected double k;
    protected double b;

    public LinearFunction(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public double evaluate(double x) {
        return k * x + b;
    }

    @Override
    public String toString() {
        return "f(x) = " + k + "x + " + b;
    }
}

class QuadraticFunction extends LinearFunction {
    private double a;

    public QuadraticFunction(double a, double k, double b) {
        super(k, b);

        if (a == 0) {
            throw new IllegalArgumentException(
                    "Коефіцієнт a не може дорівнювати нулю"
            );
        }

        this.a = a;
    }

    @Override
    public double evaluate(double x) {
        return a * x * x + super.evaluate(x);
    }

    public double getVertexX() {
        return -k / (2 * a);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + "
                + k + "x + " + b;
    }
}