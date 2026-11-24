
package semester1.practice12;

import java.util.*;

public class Task_20 {

    public static void main(String[] args) {

        List<String> stations = new ArrayList<>(
                List.of("Вокзальна",
                        "Університет",
                        "Театральна",
                        "Хрещатик",
                        "Арсенальна"));

        ListIterator<String> lit = stations.listIterator();

        System.out.println("Прямий маршрут:");

        while (lit.hasNext()) {
            System.out.println(
                    lit.nextIndex() + ". " + lit.next());
        }

        System.out.println("\nЗворотний маршрут:");

        while (lit.hasPrevious()) {
            System.out.println(
                    lit.previousIndex() + ". " + lit.previous());
        }
    }
}
