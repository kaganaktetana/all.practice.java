package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_18 {

    public static int countOccurrences(List<String> list, String target) {

        int count = 0;

        for (String element : list) {

            if (element.equals(target)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        ArrayList<String> langs = new ArrayList<>(
                List.of("Java", "Python", "C++", "Java", "Kotlin", "Java")
        );

        System.out.println("Список мов: " + langs);

        System.out.println("Чи є Kotlin: " + langs.contains("Kotlin"));
        System.out.println("Чи є Rust: " + langs.contains("Rust"));

        System.out.println("Перший Java: " + langs.indexOf("Java"));
        System.out.println("Останній Java: " + langs.lastIndexOf("Java"));

        System.out.println("Кількість Java: "
                + countOccurrences(langs, "Java"));
    }
}
