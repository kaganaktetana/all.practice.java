
package semester1.practice11;

import java.util.*;

public class Task_29 {

    public static void main(String[] args) {

        // ArrayList
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        System.out.println("ArrayList:");
        System.out.println("Елемент за індексом 1: "
                + arrayList.get(1));

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addFirst("Перший");
        linkedList.addLast("Останній");
        linkedList.addFirst("Новий початок");

        System.out.println("\nLinkedList:");
        System.out.println(linkedList);

        // Vector
        Vector<String> vector = new Vector<>();

        vector.addElement("Apple");
        vector.addElement("Banana");
        vector.addElement("Orange");

        System.out.println("\nVector:");
        System.out.println("Елемент за індексом 1: "
                + vector.elementAt(1));

        // Stack
        Stack<String> stack = new Stack<>();

        stack.push("Книга 1");
        stack.push("Книга 2");
        stack.push("Книга 3");

        System.out.println("\nStack:");

        System.out.println("Верхня книга: " + stack.peek());

        System.out.println("Дістали: " + stack.pop());
        System.out.println("Дістали: " + stack.pop());
        System.out.println("Дістали: " + stack.pop());

        System.out.println("Стек порожній: " + stack.isEmpty());
    }
}
