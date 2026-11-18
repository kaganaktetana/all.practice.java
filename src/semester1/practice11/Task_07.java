
package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_07 {

    public static List<Integer> extractDigitsFromText(String text) {

        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                digits.add(Character.getNumericValue(ch));
            }
        }

        return digits;
    }

    public static void main(String[] args) {

        String text = "Server-04: CPU 85%, RAM 16GB";

        List<Integer> digits = extractDigitsFromText(text);

        System.out.println("Знайдені цифри: " + digits);

        double temperature = Double.parseDouble("36.6");
        Double price = Double.valueOf("99.95");

        System.out.println("Temperature: " + temperature);
        System.out.println("Price: " + price);

        double d1 = 36.6;
        double d2 = Double.NaN;
        double d3 = Double.POSITIVE_INFINITY;

        System.out.println("d1 is NaN: " + Double.isNaN(d1));
        System.out.println("d2 is NaN: " + Double.isNaN(d2));

        System.out.println("d1 is Infinite: " + Double.isInfinite(d1));
        System.out.println("d3 is Infinite: " + Double.isInfinite(d3));
    }
}
