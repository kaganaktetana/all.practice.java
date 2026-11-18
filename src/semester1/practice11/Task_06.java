
package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_06 {

    public static int sumIgnoringNulls(List<Integer> list) {

        int sum = 0;

        for (Integer element : list) {
            if (element != null) {
                sum += element;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        ArrayList<Integer> temperatures = new ArrayList<>();

        temperatures.add(18);
        temperatures.add(22);
        temperatures.add(null);
        temperatures.add(15);
        temperatures.add(null);
        temperatures.add(20);

        try {
            int t = temperatures.get(2);
            System.out.println("Температура: " + t);

        } catch (NullPointerException e) {
            System.out.println("Помилка: неможливо розпакувати null!");
        }

        int result = sumIgnoringNulls(temperatures);

        System.out.println("Сума температур: " + result);
    }
}
