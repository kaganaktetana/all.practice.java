package semester1.practice12;

import java.util.HashSet;
import java.util.Set;

public class Task_01 {

    public static void main(String[] args) {

        Set<String> langs = new HashSet<>();

        System.out.println("Додавання мов програмування:");

        System.out.println(langs.add("Java"));
        System.out.println(langs.add("Python"));
        System.out.println(langs.add("C++"));
        System.out.println(langs.add("Java"));
        System.out.println(langs.add("Kotlin"));
        System.out.println(langs.add("Python"));

        System.out.println("\nРозмір множини: " + langs.size());

        System.out.println("Чи є Java? " + langs.contains("Java"));
        System.out.println("Чи є Rust? " + langs.contains("Rust"));

        langs.remove("C++");

        System.out.println("\nПісля видалення C++:");
        System.out.println(langs);
    }
}
