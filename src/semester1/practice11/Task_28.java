
package semester1.practice11;

import java.util.*;

public class Task_28 {

    public static <E> void printElements(Iterable<E> iterable) {

        Iterator<E> iterator = iterable.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }

    public static <E> void printSummary(Collection<E> collection) {

        System.out.println("Size: " + collection.size());
        System.out.println("Is empty: " + collection.isEmpty());
    }

    public static <E> E getFirstAndLast(List<E> list) {

        if (list.isEmpty()) {
            System.out.println("Список порожній!");
            return null;
        }

        System.out.println("Перший елемент: " + list.get(0));

        System.out.println("Останній елемент: "
                + list.get(list.size() - 1));

        return list.get(0);
    }

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(
                List.of("Java", "Python", "C++")
        );

        LinkedList<String> linkedList = new LinkedList<>(
                List.of("HTML", "CSS", "JavaScript")
        );

        Vector<String> vector = new Vector<>(
                List.of("One", "Two", "Three")
        );

        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("ArrayList:");
        printElements(arrayList);
        printSummary(arrayList);
        getFirstAndLast(arrayList);

        System.out.println("\nLinkedList:");
        printElements(linkedList);
        printSummary(linkedList);
        getFirstAndLast(linkedList);

        System.out.println("\nVector:");
        printElements(vector);
        printSummary(vector);
        getFirstAndLast(vector);

        System.out.println("\nStack:");
        printElements(stack);
        printSummary(stack);
        getFirstAndLast(stack);
    }
}
