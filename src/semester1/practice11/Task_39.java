
package semester1.practice11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task_39 {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int count = 20_000;

        // Вставка на початок ArrayList
        long start = System.nanoTime();

        for (int i = 0; i < count; i++) {
            arrayList.add(0, i);
        }

        long arrayInsertTime = System.nanoTime() - start;

        // Вставка на початок LinkedList
        start = System.nanoTime();

        for (int i = 0; i < count; i++) {
            linkedList.add(0, i);
        }

        long linkedInsertTime = System.nanoTime() - start;

        // Читання з середини ArrayList
        start = System.nanoTime();

        int arraySum = 0;

        for (int i = 0; i < count; i++) {
            arraySum += arrayList.get(arrayList.size() / 2);
        }

        long arrayGetTime = System.nanoTime() - start;

        // Читання з середини LinkedList
        start = System.nanoTime();

        int linkedSum = 0;

        for (int i = 0; i < count; i++) {
            linkedSum += linkedList.get(linkedList.size() / 2);
        }

        long linkedGetTime = System.nanoTime() - start;

        // Результати
        System.out.println("=== Вставка на початок ===");
        System.out.println("ArrayList: " + arrayInsertTime + " нс");
        System.out.println("LinkedList: " + linkedInsertTime + " нс");

        System.out.println("\n=== Читання з середини ===");
        System.out.println("ArrayList: " + arrayGetTime + " нс");
        System.out.println("LinkedList: " + linkedGetTime + " нс");

        System.out.println("\nКонтрольні суми: "
                + arraySum + " / " + linkedSum);

        System.out.println("\nПояснення:");
        System.out.println("ArrayList при вставці на початок зсуває "
                + "інші елементи масиву через System.arraycopy.");

        System.out.println("LinkedList вставляє елемент на початок "
                + "за O(1), змінюючи посилання.");

        System.out.println("ArrayList швидко отримує елемент за індексом "
                + "за O(1), оскільки використовує внутрішній масив Object[].");

        System.out.println("LinkedList шукає елемент за індексом "
                + "послідовним проходженням вузлів за O(n).");
    }
}
