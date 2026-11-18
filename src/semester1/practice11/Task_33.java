
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task_33 {

    public static void splitEvenAndOdd(
            List<Integer> source,
            List<Integer> evens,
            List<Integer> odds) {

        Iterator<Integer> it = source.iterator();

        while (it.hasNext()) {

            Integer n = it.next();

            if (n % 2 == 0) {
                evens.add(n);
            } else {
                odds.add(n);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                12, 7, 4, 15, 20, 9, 33, 8, 2, 17
        );

        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        splitEvenAndOdd(numbers, evens, odds);

        System.out.println("Парні числа: " + evens);
        System.out.println("Непарні числа: " + odds);

        System.out.println("Розмір парних: " + evens.size());
        System.out.println("Розмір непарних: " + odds.size());

        int maxEven = Integer.MIN_VALUE;

        for (Integer number : evens) {
            if (number > maxEven) {
                maxEven = number;
            }
        }

        int maxOdd = Integer.MIN_VALUE;

        for (Integer number : odds) {
            if (number > maxOdd) {
                maxOdd = number;
            }
        }

        System.out.println("Максимальне парне: " + maxEven);
        System.out.println("Максимальне непарне: " + maxOdd);
    }
}
