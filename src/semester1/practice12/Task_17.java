package semester1.practice12;

import java.util.*;

public class Task_17 {

    public static <T> void printViaIterator(
            Iterable<T> collection, String title) {

        System.out.println("\n" + title);

        Iterator<T> it = collection.iterator();
        int number = 1;

        while (it.hasNext()) {
            System.out.println(number + ". " + it.next());
            number++;
        }
    }

    public static void main(String[] args) {

        List<String> planetsList = new ArrayList<>(
                List.of("Меркурій", "Венера", "Земля",
                        "Марс", "Юпітер", "Сатурн",
                        "Уран", "Нептун"));

        Set<String> planetsSet = new HashSet<>(planetsList);

        Set<String> linkedSet = new LinkedHashSet<>(planetsList);

        Set<String> treeSet = new TreeSet<>(planetsList);

        printViaIterator(planetsList, "ArrayList:");
        printViaIterator(planetsSet, "HashSet:");
        printViaIterator(linkedSet, "LinkedHashSet:");
        printViaIterator(treeSet, "TreeSet:");
    }
}
