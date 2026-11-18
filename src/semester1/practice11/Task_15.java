
package semester1.practice11;

import java.util.ArrayList;

public class Task_15 {

    public static void main(String[] args) {

        // Створення списку з початковою ємністю 500
        ArrayList<String> logs = new ArrayList<>(500);

        System.out.println("Створено список з capacity 500");

        // Додавання декількох елементів
        logs.add("Application started");
        logs.add("User logged in");
        logs.add("Database connected");
        logs.add("Application running");

        System.out.println("Size: " + logs.size());

        // Забезпечення ємності для 1000 елементів
        logs.ensureCapacity(1000);

        System.out.println("Виконано ensureCapacity(1000)");

        // Обрізання невикористаної ємності
        logs.trimToSize();

        System.out.println("Виконано trimToSize()");
        System.out.println("Поточний список: " + logs);
        System.out.println("Поточний size: " + logs.size());
    }
}
