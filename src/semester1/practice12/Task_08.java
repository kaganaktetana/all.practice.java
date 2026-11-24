package semester1.practice12;

import java.util.*;

public class Task_08 {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();

        // Заповнення двох колекцій
        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i);
            hashSet.add(i);
        }

        int queries = 10_000;

        // Підготовка запитів
        int[] searchValues = new int[queries];

        for (int i = 0; i < queries; i++) {
            searchValues[i] = 90_000 + i;
        }

        // Прогрівання JVM
        for (int value : searchValues) {
            arrayList.contains(value);
            hashSet.contains(value);
        }

        int arrayFound = 0;
        int hashFound = 0;

        // Тест ArrayList
        long startArray = System.nanoTime();

        for (int value : searchValues) {
            if (arrayList.contains(value)) {
                arrayFound++;
            }
        }

        long endArray = System.nanoTime();

        // Тест HashSet
        long startHash = System.nanoTime();

        for (int value : searchValues) {
            if (hashSet.contains(value)) {
                hashFound++;
            }
        }

        long endHash = System.nanoTime();

        // Час у мілісекундах
        double arrayTime =
                (endArray - startArray) / 1_000_000.0;

        double hashTime =
                (endHash - startHash) / 1_000_000.0;

        System.out.println("Кількість елементів: " + arrayList.size());
        System.out.println("Кількість запитів: " + queries);

        System.out.printf(
                Locale.US,
                "\nArrayList time: %.3f ms%n",
                arrayTime
        );

        System.out.printf(
                Locale.US,
                "HashSet time: %.3f ms%n",
                hashTime
        );

        if (hashTime > 0) {
            System.out.printf(
                    Locale.US,
                    "HashSet швидший приблизно у %.2f разів%n",
                    arrayTime / hashTime
            );
        }

        System.out.println("\nЗнайдено ArrayList: " + arrayFound);
        System.out.println("Знайдено HashSet: " + hashFound);
    }
}
