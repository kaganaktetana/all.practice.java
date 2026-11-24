package semester1.practice12;

import java.util.*;

public class Task_24 {

    public static List<Integer> mergeLists(
            List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>();

        Iterator<Integer> itA = a.iterator();
        Iterator<Integer> itB = b.iterator();

        Integer x = itA.hasNext() ? itA.next() : null;
        Integer y = itB.hasNext() ? itB.next() : null;

        while (x != null && y != null) {

            if (x < y) {
                addUnique(result, x);
                x = itA.hasNext() ? itA.next() : null;

            } else if (x > y) {
                addUnique(result, y);
                y = itB.hasNext() ? itB.next() : null;

            } else {
                addUnique(result, x);
                x = itA.hasNext() ? itA.next() : null;
                y = itB.hasNext() ? itB.next() : null;
            }
        }

        while (x != null) {
            addUnique(result, x);
            x = itA.hasNext() ? itA.next() : null;
        }

        while (y != null) {
            addUnique(result, y);
            y = itB.hasNext() ? itB.next() : null;
        }

        return result;
    }

    private static void addUnique(List<Integer> list, Integer value) {
        if (list.isEmpty() || !list.get(list.size() - 1).equals(value)) {
            list.add(value);
        }
    }

    public static void main(String[] args) {

        List<Integer> a = List.of(1, 4, 7, 12, 20);
        List<Integer> b = List.of(2, 4, 9, 12, 15, 25);

        List<Integer> result = mergeLists(a, b);

        System.out.println("Перший список: " + a);
        System.out.println("Другий список: " + b);

        System.out.println("Результат злиття:");
        System.out.println(result);
    }
}
