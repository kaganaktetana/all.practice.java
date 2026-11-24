package semester1.practice12;

import java.util.*;

public class Task_18 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(
                List.of(10, 15, 22, 33, 40, 55, 60));

        System.out.println("Початковий список: " + numbers);

        try {
            for (Integer n : numbers) {
                if (n % 2 != 0) {
                    numbers.remove(n);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Помилка ConcurrentModificationException!");
            System.out.println("Не можна змінювати список під час for-each.");
        }

        List<Integer> safeNumbers = new ArrayList<>(
                List.of(10, 15, 22, 33, 40, 55, 60));

        Iterator<Integer> it = safeNumbers.iterator();

        while (it.hasNext()) {
            Integer n = it.next();

            if (n % 2 != 0) {
                it.remove();
            }
        }

        System.out.println("Після безпечного видалення: "
                + safeNumbers);
    }
}
