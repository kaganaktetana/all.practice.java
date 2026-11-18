package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_17 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(
                List.of(10, 20, 30, 1, 40, 2)
        );

        System.out.println("Початковий список: " + numbers);

        // Видалення за індексом
        numbers.remove(1);

        System.out.println("Після remove(1): " + numbers);

        // Видалення за значенням
        numbers.remove(Integer.valueOf(1));

        System.out.println("Після remove(Integer.valueOf(1)): " + numbers);

        numbers.remove(Integer.valueOf(2));

        System.out.println("Після remove(Integer.valueOf(2)): " + numbers);
    }
}
