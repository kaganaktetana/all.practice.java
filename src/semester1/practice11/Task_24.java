
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Task_24 {

    public static int replaceAllValues(
            List<String> list,
            String oldValue,
            String newValue) {

        int count = 0;

        for (int i = 0; i < list.size(); i++) {

            if (Objects.equals(list.get(i), oldValue)) {

                list.set(i, newValue);

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>(
                Arrays.asList("Green", "Blue", "Green", "Red", "Green", "Yellow")
        );

        System.out.println("Початковий список: " + colors);

        int replacements = replaceAllValues(colors, "Green", "Black");

        System.out.println("Після заміни: " + colors);
        System.out.println("Кількість замін: " + replacements);
    }
}
