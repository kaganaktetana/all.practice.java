
package semester1.practice11;

import java.util.ArrayList;

public class Task_26 {

    public static void demonstrateVarDiamondDanger() {

        // Небезпечний варіант: ArrayList<Object>
        var unsafeList = new ArrayList<>();

        unsafeList.add(42);
        unsafeList.add("Java");
        unsafeList.add(true);

        System.out.println("Unsafe list: " + unsafeList);

        try {
            Integer number = (Integer) unsafeList.get(0);
            System.out.println("Number: " + number);

            Integer text = (Integer) unsafeList.get(1);
            System.out.println("Text: " + text);

        } catch (ClassCastException e) {
            System.out.println("Помилка: ClassCastException!");
        }

        // Правильний варіант
        var safeList = new ArrayList<Integer>();

        safeList.add(42);
        safeList.add(100);
        safeList.add(200);

        Integer number = safeList.get(0);

        System.out.println("Safe list: " + safeList);
        System.out.println("Number: " + number);
    }

    public static void main(String[] args) {
        demonstrateVarDiamondDanger();
    }
}
