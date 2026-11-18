
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_22 {

    public static <T> ArrayList<T> deduplicate(List<T> source) {

        ArrayList<T> unique = new ArrayList<>();

        for (T item : source) {

            if (!unique.contains(item)) {
                unique.add(item);
            }
        }

        return unique;
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(5, 12, 5, 8, 12, 20, 5)
        );

        ArrayList<Integer> uniqueNumbers = deduplicate(numbers);

        System.out.println("Початкові числа: " + numbers);
        System.out.println("Без дублікатів: " + uniqueNumbers);

        ArrayList<String> names = new ArrayList<>(
                Arrays.asList("Анна", "Богдан", "Анна", "Олена", "Богдан")
        );

        ArrayList<String> uniqueNames = deduplicate(names);

        System.out.println("Початкові імена: " + names);
        System.out.println("Унікальні імена: " + uniqueNames);
    }
}
