package semester1.practice08;

public class Task_14 {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone(
                "Samsung", 25000, 256, true
        );

        Smartphone phone2 = new Smartphone(
                "Xiaomi", 15000, 128
        );

        Smartphone phone3 = new Smartphone("Apple");

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
    }
}

class Gadget {
    private String brand;
    private double price;

    public Gadget(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Бренд: " + brand
                + ", ціна: " + price + " грн";
    }
}

class Smartphone extends Gadget {
    private int memoryGb;
    private boolean has5G;

    // Повний конструктор
    public Smartphone(String brand, double price,
                      int memoryGb, boolean has5G) {
        super(brand, price);

        this.memoryGb = memoryGb;
        this.has5G = has5G;
    }

    // Середній конструктор
    public Smartphone(String brand, double price, int memoryGb) {
        this(brand, price, memoryGb, true);
    }

    // Мінімальний конструктор
    public Smartphone(String brand) {
        this(brand, 9999.0, 128, false);
    }

    @Override
    public String toString() {
        return "Смартфон: " + getBrand()
                + ", ціна: " + getPrice() + " грн"
                + ", пам'ять: " + memoryGb + " ГБ"
                + ", підтримка 5G: " + (has5G ? "так" : "ні");
    }
}