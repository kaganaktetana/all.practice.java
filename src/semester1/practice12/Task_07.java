
package semester1.practice12;

import java.util.*;

public class Task_07 {

    public static void main(String[] args) {

        TreeSet<Double> temperatures = new TreeSet<>(
                Arrays.asList(
                        -4.5, 0.0, 12.3, 18.7, 22.1,
                        25.0, 31.4, 36.6, 40.2, 15.5
                )
        );

        System.out.println("Всі температури:");
        System.out.println(temperatures);

        // Мінімальна та максимальна температура
        System.out.println("\nМінімальна температура: "
                + temperatures.first());

        System.out.println("Максимальна температура: "
                + temperatures.last());

        // Температури нижче 20
        System.out.println("\nТемператури нижче 20:");
        System.out.println(temperatures.headSet(20.0));

        // Температури від 25 і вище
        System.out.println("\nТемператури від 25:");
        System.out.println(temperatures.tailSet(25.0));

        // Комфортний діапазон [15; 32)
        System.out.println("\nКомфортний діапазон [15; 32):");
        System.out.println(temperatures.subSet(15.0, 32.0));

        // Найближчі сусідні значення до 20
        System.out.println("\nНайближчі виміри до 20:");

        System.out.println("Ceiling (>= 20): "
                + temperatures.ceiling(20.0));

        System.out.println("Floor (<= 20): "
                + temperatures.floor(20.0));
    }
}
