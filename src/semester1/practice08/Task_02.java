
package semester1.practice08;

public class Task_02 {

    public static void main(String[] args) {

        Product product1 = new Product(
                "A-101", "Монітор", 6499.50, 4
        );

        Product product2 = new Product(
                "B-205", "Клавіатура", 1200.99, 3
        );

        Product product3 = new Product(
                "C-300", "Миша", 500, 10
        );

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}

class Product {

    private String sku;
    private String title;
    private double price;
    private int stock;

    public Product(String sku, String title, double price, int stock) {
        this.sku = sku;
        this.title = title;
        setPrice(price);
        setStock(stock);
    }

    public double getTotalCost() {
        return price * stock;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                sku, title, price, stock, getTotalCost()
        );
    }
}
