
package semester1.practice12;

import java.util.*;

public class Task_23 {

    public static int removeDuplicatesInPlace(List<String> list) {

        Set<String> seen = new HashSet<>();
        Iterator<String> it = list.iterator();

        int removed = 0;

        while (it.hasNext()) {

            String element = it.next();

            if (!seen.add(element)) {
                it.remove();
                removed++;
            }
        }

        return removed;
    }

    public static void main(String[] args) {

        List<String> tags = new ArrayList<>(
                List.of("oop", "java", "set", "java",
                        "iterator", "oop", "list", "set"));

        System.out.println("До видалення:");
        System.out.println(tags);

        int removed = removeDuplicatesInPlace(tags);

        System.out.println("\nПісля видалення:");
        System.out.println(tags);

        System.out.println("Кількість видалених дублікатів: " + removed);
    }
}
