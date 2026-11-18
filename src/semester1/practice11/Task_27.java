
package semester1.practice11;

import java.util.*;

public class Task_27 {

    public static void exploreCollectionHierarchy() {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Vector<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();

        HashSet<String> hashSet = new HashSet<>();

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        System.out.println("ArrayList:");
        System.out.println("List: " + (arrayList instanceof List));
        System.out.println("Collection: " + (arrayList instanceof Collection));
        System.out.println("Iterable: " + (arrayList instanceof Iterable));

        System.out.println("\nLinkedList:");
        System.out.println("List: " + (linkedList instanceof List));
        System.out.println("Collection: " + (linkedList instanceof Collection));
        System.out.println("Iterable: " + (linkedList instanceof Iterable));

        System.out.println("\nVector:");
        System.out.println("List: " + (vector instanceof List));
        System.out.println("Collection: " + (vector instanceof Collection));
        System.out.println("Iterable: " + (vector instanceof Iterable));

        System.out.println("\nStack:");
        System.out.println("List: " + (stack instanceof List));
        System.out.println("Collection: " + (stack instanceof Collection));
        System.out.println("Iterable: " + (stack instanceof Iterable));

        System.out.println("\nHashSet:");
        System.out.println("Set: " + (hashSet instanceof Set));
        System.out.println("Collection: " + (hashSet instanceof Collection));
        System.out.println("Iterable: " + (hashSet instanceof Iterable));

        System.out.println("\nArrayDeque:");
        System.out.println("Queue: " + (arrayDeque instanceof Queue));
        System.out.println("Collection: " + (arrayDeque instanceof Collection));
        System.out.println("Iterable: " + (arrayDeque instanceof Iterable));
    }

    public static void main(String[] args) {
        exploreCollectionHierarchy();
    }
}
