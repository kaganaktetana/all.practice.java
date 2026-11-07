package semester1.practice08;

public class Task_08 {
    public static void main(String[] args) {
        InvoiceItem item = new InvoiceItem(
                "Клавіатура",
                2,
                1200.0,
                15.0
        );

        System.out.println(item);

        // Java автоматично викликає item.toString()
        System.out.println("Позиція чека: " + item);
    }
}

class InvoiceItem {
    private String description;
    private int quantity;
    private double unitPrice;
    private double discountPercent;

    public InvoiceItem(String description, int quantity,
                       double unitPrice, double discountPercent) {

        if (quantity < 0) {
            throw new IllegalArgumentException("Кількість не може бути від'ємною");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }

        if (discountPercent < 0 || discountPercent > 50) {
            throw new IllegalArgumentException("Знижка має бути від 0 до 50%");
        }

        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountPercent = discountPercent;
    }

    public double getFinalAmount() {
        double total = quantity * unitPrice;

        return total - total * discountPercent / 100;
    }

    @Override
    public String toString() {
        return "Товар: " + description
                + ", кількість: " + quantity
                + ", ціна: " + unitPrice
                + ", знижка: " + discountPercent + "%"
                + ", підсумок: " + getFinalAmount();
    }
}
