
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_36 {

    public static String[] mergeUniqueToArray(
            List<String> first,
            List<String> second) {

        var merged = new ArrayList<String>();

        for (String item : first) {
            if (!merged.contains(item)) {
                merged.add(item);
            }
        }

        for (String item : second) {
            if (!merged.contains(item)) {
                merged.add(item);
            }
        }

        return merged.toArray(new String[0]);
    }

    public static void main(String[] args) {

        List<String> first = Arrays.asList(
                "Java", "Python", "C++"
        );

        List<String> second = Arrays.asList(
                "Python", "JavaScript", "C#"
        );

        String[] result = mergeUniqueToArray(first, second);

        System.out.println("Масив без дублікатів: "
                + Arrays.toString(result));
    }
}
