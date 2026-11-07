package semester1.practice08;

import java.util.Arrays;

public class Task_36 {
    public static void main(String[] args) {

        double[] prices = {500, 600, 550, 650};

        WarehouseItem item = new WarehouseItem(
                "Монітор", 10, prices
        );

        DiscountedWarehouseItem discounted =
                new DiscountedWarehouseItem(
                        "Монітор", 10, prices,
                        "Пошкоджена упаковка", 20
                );

        System.out.println(item);
        System.out.println();

        System.out.println(discounted);
    }
}

class WarehouseItem {
    private String name;
    private int quantity;
    private double[] priceHistory;

    public WarehouseItem(String name, int quantity,
                         double[] priceHistory) {
        this.name = name;
        this.quantity = quantity;
        this.priceHistory = Arrays.copyOf(
                priceHistory, priceHistory.length
        );
    }

    public double getAveragePurchasePrice() {
        if (priceHistory.length == 0) {
            return 0;
        }

        double sum = 0;

        for (double price : priceHistory) {
            sum += price;
        }

        return sum / priceHistory.length;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Товар: " + name
                + ", кількість: " + quantity
                + ", історія цін: "
                + Arrays.toString(priceHistory)
                + ", середня закупівельна ціна: "
                + getAveragePurchasePrice() + " грн";
    }
}

class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;

    public DiscountedWarehouseItem(String name, int quantity,
                                   double[] priceHistory,
                                   String markdownReason,
                                   double discountPercent) {
        super(name, quantity, priceHistory);

        this.markdownReason = markdownReason;

        if (discountPercent >= 0 && discountPercent <= 100) {
            this.discountPercent = discountPercent;
        } else {
            this.discountPercent = 0;
        }
    }

    public double getSalePrice() {
        return getAveragePurchasePrice()
                * (1 - discountPercent / 100.0);
    }

    public double getTotalSaleValue() {
        return getSalePrice() * getQuantity();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nПричина уцінки: " + markdownReason
                + "\nЗнижка: " + discountPercent + "%"
                + "\nЦіна розпродажу: " + getSalePrice() + " грн"
                + "\nВартість усього залишку: "
                + getTotalSaleValue() + " грн";
    }
}
