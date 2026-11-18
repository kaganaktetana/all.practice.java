
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_20 {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>(
                List.of("Київ", "Львів", "Одеса", "Харків", "Дніпро")
        );

        System.out.println("Початковий ArrayList: " + cities);

        // Перетворення у масив Object[]
        Object[] objArray = cities.toArray();

        System.out.println("Масив Object[]: "
                + Arrays.toString(objArray));

        // Перетворення у масив String[]
        String[] strArray = cities.toArray(new String[0]);

        System.out.println("Масив String[]: "
                + Arrays.toString(strArray));

        // Зворотне перетворення у ArrayList
        ArrayList<String> newCities = new ArrayList<>(
                Arrays.asList(strArray)
        );

        System.out.println("Новий ArrayList: " + newCities);
    }
}
