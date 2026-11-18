
package semester1.practice11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task_38 {

    public static void main(String[] args) {

        List<String> receiptLines = List.of(
                "Хліб: 35",
                "Молоко: 48",
                "Помилка сканера: N/A",
                "Кава: 240",
                "Пакет: 5",
                "Сир: 185"
        );

        var prices = new ArrayList<Integer>();

        // Витягування цін
        for (String line : receiptLines) {

            try {

                String priceText = line.substring(
                        line.indexOf(":") + 1
                ).trim();

                int price = Integer.parseInt(priceText);

                prices.add(price);

            } catch (NumberFormatException e) {

                System.out.println("Пропущено некоректний рядок: " + line);
            }
        }

        System.out.println("Усі знайдені ціни: " + prices);

        // Видалення покупок дешевших за 40 грн
        Iterator<Integer> it = prices.iterator();

        while (it.hasNext()) {

            Integer price = it.next();

            if (price < 40) {
                it.remove();
            }
        }

        // Підрахунок суми
        int total = 0;

        for (Integer price : prices) {
            total += price;
        }

        System.out.println("Ціни після фільтрації: " + prices);
        System.out.println("Сума до сплати: " + total + " грн");
    }
}
