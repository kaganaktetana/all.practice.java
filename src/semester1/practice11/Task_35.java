
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_35 {

    public static <T> void reverseInPlace(List<T> list) {

        for (int i = 0; i < list.size() / 2; i++) {

            int oppositeIndex = list.size() - 1 - i;

            T first = list.get(i);
            T last = list.get(oppositeIndex);

            list.set(i, last);
            list.set(oppositeIndex, first);
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );

        System.out.println("До розвороту: " + numbers);

        reverseInPlace(numbers);

        System.out.println("Після розвороту: " + numbers);

        ArrayList<String> names = new ArrayList<>(
                Arrays.asList("Анна", "Богдан", "Олена")
        );

        reverseInPlace(names);

        System.out.println("Розворот імен: " + names);
    }
}
