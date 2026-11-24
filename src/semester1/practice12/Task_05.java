package semester1.practice12;

import java.util.*;

public class Task_05 {

    public static void main(String[] args) {

        String text = "Java is fast, Java is safe! Collections: List, Set, and Iterator.";

        // Видаляємо розділові знаки
        String cleanedText = text.replaceAll("[^a-zA-Zа-яА-ЯіІїЇєЄґҐ\\s]", "");

        // Переводимо всі слова у нижній регістр
        cleanedText = cleanedText.toLowerCase();

        // Розбиваємо текст на слова
        String[] words = cleanedText.trim().split("\\s+");

        // Створюємо відсортовану множину
        TreeSet<String> uniqueWords = new TreeSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        int totalWords = words.length;
        int uniqueCount = uniqueWords.size();

        double diversity =
                (double) uniqueCount / totalWords * 100;

        System.out.println("Початковий текст:");
        System.out.println(text);

        System.out.println("\nУсі слова:");
        System.out.println(Arrays.toString(words));

        System.out.println("\nУнікальні слова:");
        System.out.println(uniqueWords);

        System.out.println("\nСтатистика:");
        System.out.println("Загальна кількість слів: " + totalWords);
        System.out.println("Кількість унікальних слів: " + uniqueCount);

        System.out.println("Перше слово за алфавітом: "
                + uniqueWords.first());

        System.out.println("Останнє слово за алфавітом: "
                + uniqueWords.last());

        System.out.printf(
                Locale.US,
                "Лексичне різноманіття: %.2f%%%n",
                diversity
        );
    }
}
