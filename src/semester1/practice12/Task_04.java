package semester1.practice12;

import java.util.*;

public class Task_04 {

    public static String findFirstDuplicate(List<String> ids) {

        Set<String> seen = new HashSet<>();

        for (String id : ids) {

            if (!seen.add(id)) {
                return id;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        List<String> receiptIds = Arrays.asList(
                "BANK-101",
                "BANK-205",
                "BANK-310",
                "BANK-101",
                "BANK-450",
                "BANK-205"
        );

        List<String> uniqueIds = Arrays.asList(
                "BANK-111",
                "BANK-222",
                "BANK-333",
                "BANK-444"
        );

        System.out.println("Список із дублікатами:");
        System.out.println(receiptIds);

        System.out.println("Перший дублікат: "
                + findFirstDuplicate(receiptIds));

        System.out.println("\nУнікальний список:");
        System.out.println(uniqueIds);

        String result = findFirstDuplicate(uniqueIds);

        if (result == null) {
            System.out.println("Дублікатів не знайдено!");
        } else {
            System.out.println("Перший дублікат: " + result);
        }
    }
}
