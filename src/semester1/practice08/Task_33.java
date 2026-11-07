package semester1.practice08;

import java.util.Arrays;

public class Task_33 {
    public static void main(String[] args) {

        ArithmeticProgression arithmetic =
                new ArithmeticProgression(2, 3);

        GeometricProgression geometric =
                new GeometricProgression(2, 2);

        System.out.println(arithmetic);
        System.out.println();

        System.out.println(geometric);
    }
}

class Progression {
    protected double firstTerm;
    protected double step;

    public Progression(double firstTerm, double step) {
        this.firstTerm = firstTerm;
        this.step = step;
    }

    public double getTerm(int index) {
        return firstTerm;
    }

    public double[] generateFirstN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Кількість членів не може бути від'ємною"
            );
        }

        double[] result = new double[n];

        for (int i = 1; i <= n; i++) {
            result[i - 1] = getTerm(i);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Перша прогресія: " + firstTerm
                + ", крок: " + step;
    }
}

class ArithmeticProgression extends Progression {

    public ArithmeticProgression(double firstTerm, double difference) {
        super(firstTerm, difference);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm + (n - 1) * step;
    }

    @Override
    public String toString() {
        return "Арифметична прогресія"
                + "\nФормула: a(n) = a1 + (n - 1) * d"
                + "\nПерший член: " + firstTerm
                + "\nРізниця: " + step
                + "\nПерші 5 членів: "
                + Arrays.toString(generateFirstN(5));
    }
}

class GeometricProgression extends Progression {

    public GeometricProgression(double firstTerm, double ratio) {
        super(firstTerm, ratio);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm * Math.pow(step, n - 1);
    }

    @Override
    public String toString() {
        return "Геометрична прогресія"
                + "\nФормула: b(n) = b1 * q^(n - 1)"
                + "\nПерший член: " + firstTerm
                + "\nЗнаменник: " + step
                + "\nПерші 5 членів: "
                + Arrays.toString(generateFirstN(5));
    }
}