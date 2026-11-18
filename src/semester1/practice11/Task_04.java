
package semester1.practice11;

import java.util.Arrays;
import java.util.List;

public class Task_04 {

    public static void findMinAndMax(List<Integer> numbers) {

        if (numbers.isEmpty()) {
            System.out.println("Список порожній!");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }

        System.out.println("Мінімум: " + min);
        System.out.println("Максимум: " + max);
    }

    public static void main(String[] args) {

        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);

        System.out.println("Byte.MAX_VALUE: " + Byte.MAX_VALUE);
        System.out.println("Byte.MIN_VALUE: " + Byte.MIN_VALUE);

        System.out.println("Short.MAX_VALUE: " + Short.MAX_VALUE);
        System.out.println("Short.MIN_VALUE: " + Short.MIN_VALUE);

        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
        System.out.println("Long.MIN_VALUE: " + Long.MIN_VALUE);

        List<Integer> numbers = Arrays.asList(15, -8, 100, 25, 0);

        findMinAndMax(numbers);

        // Переповнення
        int max = Integer.MAX_VALUE;

        System.out.println("MAX_VALUE + 1: " + (max + 1));

        // Безпечна перевірка перед додаванням
        if (max < Integer.MAX_VALUE) {
            max++;
        } else {
            System.out.println("Неможливо додати: досягнуто максимум!");
        }
    }
}
