
package semester1.practice12;

import java.util.*;

public class Task_22 {

    public static int cleanWithIterator(List<Double> data) {

        Iterator<Double> it = data.iterator();
        int removed = 0;

        while (it.hasNext()) {
            Double v = it.next();

            if (v == null || Double.isNaN(v) || v < 0 || v > 100.0) {
                it.remove();
                removed++;
            }
        }

        return removed;
    }

    public static int cleanWithRemoveIf(List<Double> data) {

        int oldSize = data.size();

        data.removeIf(v -> v == null ||
                Double.isNaN(v) || v < 0 || v > 100.0);

        return oldSize - data.size();
    }

    public static double calculateAverage(List<Double> data) {

        double sum = 0;

        for (Double value : data) {
            sum += value;
        }

        return data.isEmpty() ? 0 : sum / data.size();
    }

    public static void main(String[] args) {

        List<Double> readings = new ArrayList<>(
                Arrays.asList(25.5, 30.0, -5.0, 45.2,
                        Double.NaN, 110.0, 60.5, 70.0,
                        0.0, 85.5, -10.0, 95.0));

        List<Double> readings2 = new ArrayList<>(readings);

        System.out.println("Початкові показники:");
        System.out.println(readings);

        int removed1 = cleanWithIterator(readings);
        int removed2 = cleanWithRemoveIf(readings2);

        System.out.println("\nПісля Iterator:");
        System.out.println(readings);

        System.out.println("Видалено: " + removed1);

        System.out.println("\nПісля removeIf:");
        System.out.println(readings2);

        System.out.println("Видалено: " + removed2);

        System.out.println("\nРезультати однакові: "
                + readings.equals(readings2));

        System.out.printf("Середня температура: %.2f%n",
                calculateAverage(readings));
    }
}
