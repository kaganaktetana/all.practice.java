package semester1.practice10;

interface Integrable1D {
    double evaluate(double x);

    default double integrateTrapezoid(double a, double b, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Кількість відрізків має бути більшою за нуль"
            );
        }

        double h = (b - a) / n;
        double sum = (evaluate(a) + evaluate(b)) / 2.0;

        for (int i = 1; i < n; i++) {
            sum += evaluate(a + i * h);
        }

        return sum * h;
    }
}

interface RootFindable {
    double findRootBisection(double left, double right, double eps);
}

abstract class AbstractAnalyticFunction implements Integrable1D {
}

class CubicFunction extends AbstractAnalyticFunction
        implements RootFindable {

    @Override
    public double evaluate(double x) {
        return x * x * x - 2 * x - 5;
    }

    @Override
    public double findRootBisection(
            double left, double right, double eps) {

        if (eps <= 0) {
            throw new IllegalArgumentException(
                    "Точність має бути більшою за нуль"
            );
        }

        double fLeft = evaluate(left);
        double fRight = evaluate(right);

        if (fLeft * fRight > 0) {
            throw new IllegalArgumentException(
                    "На кінцях відрізка функція має бути різних знаків"
            );
        }

        while ((right - left) / 2.0 > eps) {
            double middle = (left + right) / 2.0;
            double fMiddle = evaluate(middle);

            if (Math.abs(fMiddle) < eps) {
                return middle;
            }

            if (fLeft * fMiddle < 0) {
                right = middle;
            } else {
                left = middle;
                fLeft = fMiddle;
            }
        }

        return (left + right) / 2.0;
    }
}

abstract class Task_38 {

    public static void main(String[] args) {
        CubicFunction function = new CubicFunction();

        double integral = function.integrateTrapezoid(0, 3, 100000);

        double root = function.findRootBisection(
                2.0, 3.0, 0.000001
        );

        System.out.println("Інтеграл на [0; 3]: " + integral);
        System.out.println("Корінь рівняння: " + root);
        System.out.println("Значення функції в корені: "
                + function.evaluate(root));
    }
}