
package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_03 {

    public static List<Integer> parseNumbersFromStrings(String[] inputs) {

        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (String str : inputs) {
            try {
                int number = Integer.parseInt(str);
                Integer object = Integer.valueOf(str);

                sum += number;
                numbers.add(object);

            } catch (NumberFormatException e) {
                System.out.println("Некоректний рядок: \"" + str + "\"");
            }
        }

        System.out.println("Загальна сума: " + sum);

        return numbers;
    }

    public static void main(String[] args) {

        String[] inputs = {"120", "-45", "300", "abc", "1024", ""};

        List<Integer> result = parseNumbersFromStrings(inputs);

        System.out.println("Результат: " + result);
    }
}
