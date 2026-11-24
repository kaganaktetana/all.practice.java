package semester1.practice12;

import java.util.*;

public class Task_09 {

    // Об'єднання A U B
    public static <T> Set<T> union(Set<T> a, Set<T> b) {

        Set<T> result = new HashSet<>(a);
        result.addAll(b);

        return result;
    }

    // Перетин A ∩ B
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {

        Set<T> result = new HashSet<>(a);
        result.retainAll(b);

        return result;
    }

    // Різниця A \ B
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {

        Set<T> result = new HashSet<>(a);
        result.removeAll(b);

        return result;
    }

    // Симетрична різниця A △ B
    public static <T> Set<T> symmetricDifference(
            Set<T> a, Set<T> b) {

        Set<T> result = union(a, b);

        Set<T> common = intersection(a, b);

        result.removeAll(common);

        return result;
    }

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        Set<Integer> b = new HashSet<>(
                Arrays.asList(4, 5, 6, 7, 8)
        );

        System.out.println("Множина A: " + a);
        System.out.println("Множина B: " + b);

        System.out.println("\nОб'єднання A U B:");
        System.out.println(union(a, b));

        System.out.println("\nПеретин A ∩ B:");
        System.out.println(intersection(a, b));

        System.out.println("\nРізниця A \\ B:");
        System.out.println(difference(a, b));

        System.out.println("\nСиметрична різниця A △ B:");
        System.out.println(symmetricDifference(a, b));

        // Перевірка, що початкові множини не змінилися
        System.out.println("\nПочаткові множини після операцій:");

        System.out.println("A: " + a);
        System.out.println("B: " + b);
    }
}
