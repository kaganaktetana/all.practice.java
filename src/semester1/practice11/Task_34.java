
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task_34 {

    public static int removeInRange(List<Integer> list, int min, int max) {

        int count = 0;

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {

            Integer number = it.next();

            if (number >= min && number <= max) {

                it.remove();

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(5, 12, 18, 25, 30, 7, 42, 15, 50, 9)
        );

        System.out.println("Початковий список: " + numbers);

        int removed = removeInRange(numbers, 10, 30);

        System.out.println("Кількість видалених: " + removed);
        System.out.println("Результат: " + numbers);
    }
}
