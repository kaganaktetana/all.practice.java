package semester1.practice11;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Task_31 {

    public static void removeNegativesWithIterator(List<Integer> list) {

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {

            Integer number = it.next();

            if (number < 0) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> data = new ArrayList<>(
                List.of(15, -3, 42, -10, 8, -1, 25)
        );

        // Демонстрація помилки
        try {

            for (Integer x : data) {

                if (x < 0) {
                    data.remove(x);
                }
            }

        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException!");
            System.out.println("Не можна змінювати список напряму під час обходу.");
        }

        // Правильне рішення
        data = new ArrayList<>(
                List.of(15, -3, 42, -10, 8, -1, 25)
        );

        removeNegativesWithIterator(data);

        System.out.println("Список без від'ємних чисел: " + data);
    }
}
