
package semester1.practice12;

import java.util.*;

class ArithmeticProgression implements Iterable<Double> {

    private final double first;
    private final double step;
    private final int count;

    public ArithmeticProgression(double first, double step, int count) {

        if (count < 0) {
            throw new IllegalArgumentException(
                    "Кількість елементів не може бути від'ємною!");
        }

        this.first = first;
        this.step = step;
        this.count = count;
    }

    @Override
    public Iterator<Double> iterator() {

        return new Iterator<Double>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Double next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                double value = first + index * step;
                index++;

                return value;
            }
        };
    }
}

public class Task_25 {

    public static void main(String[] args) {

        double first = 2.0;
        double step = 3.0;
        int count = 10;

        ArithmeticProgression progression =
                new ArithmeticProgression(first, step, count);

        double sum = 0;

        System.out.println("Арифметична прогресія:");

        for (double value : progression) {
            System.out.print(value + " ");
            sum += value;
        }

        double formulaSum =
                count * (2 * first + (count - 1) * step) / 2;

        System.out.println("\n\nСума через цикл: " + sum);

        System.out.println("Сума за формулою: " + formulaSum);

        System.out.println("Результати збігаються: "
                + (Math.abs(sum - formulaSum) < 0.000001));
    }
}
