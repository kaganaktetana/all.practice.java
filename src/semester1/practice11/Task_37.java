
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_37 {

    public static <T> void rotateRight(List<T> list, int k) {

        if (!list.isEmpty()) {

            k = k % list.size();

            for (int i = 0; i < k; i++) {

                T last = list.remove(list.size() - 1);

                list.add(0, last);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        System.out.println("До зсуву: " + numbers);

        rotateRight(numbers, 2);

        System.out.println("Після зсуву: " + numbers);
    }
}
