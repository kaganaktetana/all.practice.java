package semester1.practice12;

import java.util.*;

public class Task_02 {

    public static void main(String[] args) {

        String[] cities = {
                "Львів", "Київ", "Одеса", "Дніпро",
                "Харків", "Київ", "Львів", "Чернівці"
        };

        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String city : cities) {
            hashSet.add(city);
            linkedHashSet.add(city);
            treeSet.add(city);
        }

        System.out.println("HashSet:");
        System.out.println(hashSet);

        System.out.println("\nLinkedHashSet:");
        System.out.println(linkedHashSet);

        System.out.println("\nTreeSet:");
        System.out.println(treeSet);

        // HashSet не гарантує порядок елементів.
        // LinkedHashSet зберігає порядок додавання.
        // TreeSet автоматично сортує елементи за алфавітом.
        // Усі три множини автоматично видаляють дублікати.
    }
}
