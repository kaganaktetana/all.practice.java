package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_25 {

    public static void demonstrateTypeInference() {

        // Спосіб 1: Diamond Operator
        List<Integer> list1 = new ArrayList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);

        // list1.add("Hello"); // Помилка компіляції

        // Спосіб 2: var
        var list2 = new ArrayList<Integer>();

        list2.add(100);
        list2.add(200);
        list2.add(300);

        // list2.add("Text"); // Помилка компіляції

        // Спосіб 3: var зі списком String
        var names = new ArrayList<String>(
                List.of("Анна", "Богдан")
        );

        names.add("Олена");
        names.add("Іван");

        // names.add(123); // Помилка компіляції

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("names: " + names);
    }

    public static void main(String[] args) {
        demonstrateTypeInference();
    }
}
