
package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_10 {

    public static List<Integer> traceArrayListCapacity(int elementsCount) {

        ArrayList<Integer> numbers = new ArrayList<>();

        int capacity = 0;

        for (int i = 1; i <= elementsCount; i++) {

            if (capacity == 0) {
                capacity = 10;

                System.out.println(
                        "Елемент №" + i +
                                ": початкова ємність = " + capacity
                );

            } else if (i > capacity) {

                int oldCapacity = capacity;

                capacity = oldCapacity + (oldCapacity >> 1);

                System.out.println(
                        "Елемент №" + i +
                                ": розширення " + oldCapacity +
                                " -> " + capacity
                );
            }

            numbers.add(i);
        }

        return numbers;
    }

    public static void main(String[] args) {

        List<Integer> numbers = traceArrayListCapacity(100);

        System.out.println("Кількість елементів: " + numbers.size());
    }
}
