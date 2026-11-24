
package semester1.practice12;

import java.util.*;

public class Task_06 {

    public static boolean registerPromoCode(
            Set<String> activeCodes, String code) {

        if (code == null || code.trim().isEmpty()) {
            return false;
        }

        String normalizedCode = code.trim().toUpperCase();

        return activeCodes.add(normalizedCode);
    }

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add(null);
        System.out.println("HashSet після null: " + hashSet);
        System.out.println("Розмір: " + hashSet.size());

        hashSet.add(null);
        System.out.println("Після повторного null: " + hashSet.size());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(null);
        linkedHashSet.add(null);

        System.out.println("\nLinkedHashSet: " + linkedHashSet);
        System.out.println("Розмір: " + linkedHashSet.size());

        TreeSet<String> treeSet = new TreeSet<>();

        try {
            treeSet.add(null);
        } catch (NullPointerException e) {
            System.out.println("\nTreeSet не підтримує null!");
        }

        // Реєстрація промокодів
        Set<String> activeCodes = new HashSet<>();

        System.out.println("\nРеєстрація промокодів:");

        System.out.println(registerPromoCode(activeCodes, "summer2026"));
        System.out.println(registerPromoCode(activeCodes, "winter2026"));
        System.out.println(registerPromoCode(activeCodes, "SUMMER2026"));
        System.out.println(registerPromoCode(activeCodes, null));
        System.out.println(registerPromoCode(activeCodes, ""));

        System.out.println("\nАктивні промокоди:");
        System.out.println(activeCodes);
    }
}
