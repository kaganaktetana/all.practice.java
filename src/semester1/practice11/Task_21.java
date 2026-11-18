
package semester1.practice11;

import java.util.ArrayList;

public class Task_21 {

    public static void manageTaskList() {

        ArrayList<String> tasks = new ArrayList<>();

        // Перевірка порожнього списку
        System.out.println("Список порожній: " + tasks.isEmpty());

        // Додавання задач
        tasks.add("Вивчити Java");
        tasks.add("Зробити домашнє завдання");
        tasks.add("Прочитати лекцію");
        tasks.add("Написати код");
        tasks.add("Перевірити програму");

        System.out.println("Після додавання: " + tasks);

        // Вставка термінової задачі
        tasks.add(0, "Терміново здати практичну");

        System.out.println("Після вставки: " + tasks);

        // Читання задачі
        System.out.println("Задача №2: " + tasks.get(1));

        // Оновлення задачі
        tasks.set(1, "Вивчити Java поглиблено");

        System.out.println("Після оновлення: " + tasks);

        // Перевірка наявності
        System.out.println("Чи є задача: "
                + tasks.contains("Написати код"));

        // Видалення за назвою
        tasks.remove("Прочитати лекцію");

        System.out.println("Після видалення за назвою: " + tasks);

        // Видалення за індексом
        tasks.remove(0);

        System.out.println("Після видалення за індексом: " + tasks);

        // Розмір списку
        System.out.println("Фінальний size: " + tasks.size());

        // Перетворення у масив
        Object[] taskArray = tasks.toArray();

        System.out.println("Масив задач:");

        for (Object task : taskArray) {
            System.out.println(task);
        }

        // Очищення
        tasks.clear();

        System.out.println("Після clear(): " + tasks);
        System.out.println("Список порожній: " + tasks.isEmpty());
    }

    public static void main(String[] args) {
        manageTaskList();
    }
}
