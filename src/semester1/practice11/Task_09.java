
package semester1.practice11;

import java.util.ArrayList;

public class Task_09 {

    public static void main(String[] args) {

        // Звичайний масив
        String[] fixedArray = new String[3];

        fixedArray[0] = "Київ";
        fixedArray[1] = "Львів";
        fixedArray[2] = "Одеса";

        System.out.println("Звичайний масив:");

        for (String city : fixedArray) {
            System.out.println(city);
        }

        try {
            fixedArray[3] = "Харків";

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Помилка: масив не може збільшити розмір!");
        }

        // Динамічний ArrayList
        ArrayList<String> dynamicList = new ArrayList<>();

        dynamicList.add("Київ");
        dynamicList.add("Львів");
        dynamicList.add("Одеса");

        dynamicList.add("Харків");
        dynamicList.add("Дніпро");

        dynamicList.add(1, "Тернопіль");

        dynamicList.remove(0);

        System.out.println("Динамічний список:");
        System.out.println(dynamicList);
    }
}
