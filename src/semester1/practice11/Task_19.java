package semester1.practice11;

import java.util.ArrayList;

public class Task_19 {

    public static void main(String[] args) {

        ArrayList<String> cart = new ArrayList<>();

        System.out.println("Початковий кошик:");
        System.out.println("isEmpty: " + cart.isEmpty());
        System.out.println("size: " + cart.size());

        // Додавання товарів
        cart.add("Молоко");
        cart.add("Хліб");
        cart.add("Сир");
        cart.add("Яблука");

        System.out.println("\nПісля додавання товарів:");
        System.out.println("Кошик: " + cart);
        System.out.println("isEmpty: " + cart.isEmpty());
        System.out.println("size: " + cart.size());

        // Оформлення замовлення
        cart.clear();

        System.out.println("\nПісля оформлення замовлення:");
        System.out.println("Кошик: " + cart);
        System.out.println("isEmpty: " + cart.isEmpty());
        System.out.println("size: " + cart.size());
    }
}
