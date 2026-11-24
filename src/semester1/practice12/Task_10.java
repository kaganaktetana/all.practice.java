package semester1.practice12;

import java.util.*;

public class Task_10 {

    // Обчислення коефіцієнта Жаккара
    public static double jaccardSimilarity(
            Set<String> a, Set<String> b) {

        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(b);

        Set<String> union = new HashSet<>(a);
        union.addAll(b);

        if (union.isEmpty()) {
            return 1.0;
        }

        return (double) intersection.size() / union.size();
    }

    // Пошук відсутніх навичок
    public static Set<String> missingSkills(
            Set<String> candidate, Set<String> vacancy) {

        Set<String> missing = new HashSet<>(vacancy);

        missing.removeAll(candidate);

        return missing;
    }

    public static void main(String[] args) {

        // Навички кандидатів
        Set<String> candidate1 = new HashSet<>(
                Arrays.asList("Java", "SQL", "Git", "Spring")
        );

        Set<String> candidate2 = new HashSet<>(
                Arrays.asList("Python", "SQL", "Docker")
        );

        Set<String> candidate3 = new HashSet<>(
                Arrays.asList("Java", "SQL", "Git", "Docker", "Spring", "Python")
        );

        // Вимоги вакансії
        Set<String> vacancy = new HashSet<>(
                Arrays.asList("Java", "SQL", "Git", "Docker", "Spring")
        );

        System.out.println("Вимоги вакансії:");
        System.out.println(vacancy);

        // Кандидат 1
        System.out.println("\n--- Кандидат 1 ---");

        System.out.printf(
                Locale.US,
                "Схожість: %.2f%%%n",
                jaccardSimilarity(candidate1, vacancy) * 100
        );

        System.out.println("Не вистачає навичок: "
                + missingSkills(candidate1, vacancy));

        // Кандидат 2
        System.out.println("\n--- Кандидат 2 ---");

        System.out.printf(
                Locale.US,
                "Схожість: %.2f%%%n",
                jaccardSimilarity(candidate2, vacancy) * 100
        );

        System.out.println("Не вистачає навичок: "
                + missingSkills(candidate2, vacancy));

        // Кандидат 3
        System.out.println("\n--- Кандидат 3 ---");

        System.out.printf(
                Locale.US,
                "Схожість: %.2f%%%n",
                jaccardSimilarity(candidate3, vacancy) * 100
        );

        System.out.println("Не вистачає навичок: "
                + missingSkills(candidate3, vacancy));
    }
}
