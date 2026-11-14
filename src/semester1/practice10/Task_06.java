
package semester1.practice10;

abstract class DifferentiableFunction {

    public abstract double f(double x);

    public double derivativeAt(double x) {
        double h = 0.00001;
        return (f(x + h) - f(x - h)) / (2 * h);
    }
}

class QuadraticParabola extends DifferentiableFunction {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticParabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double f(double x) {
        return a * x * x + b * x + c;
    }
}

class NaturalLogFunction extends DifferentiableFunction {
    private final double k;

    public NaturalLogFunction(double k) {
        this.k = k;
    }

    @Override
    public double f(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x має бути більше нуля");
        }

        return k * Math.log(x);
    }
}

class ExponentialGrowth extends DifferentiableFunction {
    private final double A;
    private final double lambda;

    public ExponentialGrowth(double A, double lambda) {
        this.A = A;
        this.lambda = lambda;
    }

    @Override
    public double f(double x) {
        return A * Math.exp(lambda * x);
    }
}

public class Task_06 {

    public static void main(String[] args) {

        DifferentiableFunction[] functions = {
                new QuadraticParabola(2, 3, 1),
                new NaturalLogFunction(4),
                new ExponentialGrowth(2, 0.5)
        };

        double x = 2.0;

        System.out.println("Функція\t\tЗначення\tПохідна");

        for (DifferentiableFunction function : functions) {
            System.out.printf(
                    "%-22s %.5f\t%.5f%n",
                    function.getClass().getSimpleName(),
                    function.f(x),
                    function.derivativeAt(x)
            );
        }
    }
}
