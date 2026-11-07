package semester1.practice08;

public class Task_24 {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Темне обсмаження", 200, 60);

        LatteWithAddons latte = new LatteWithAddons(
                "Середнє обсмаження",
                300,
                80,
                "рослинне",
                2
        );

        System.out.println(coffee);
        System.out.println();
        System.out.println(latte);
    }
}

class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;

    public Coffee(String roastType, int volumeMl, double basePrice) {
        this.roastType = roastType;
        this.volumeMl = volumeMl;
        this.basePrice = basePrice;
    }

    public double calculateCalories() {
        // Умовна калорійність чорної кави: 2 ккал на 100 мл
        return volumeMl * 0.02;
    }

    public double calculatePrice() {
        return basePrice;
    }

    public String getRoastType() {
        return roastType;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Кава: " + roastType
                + ", об'єм: " + volumeMl + " мл"
                + ", ціна: " + calculatePrice() + " грн"
                + ", калорійність: " + calculateCalories() + " ккал";
    }
}

class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;

    public LatteWithAddons(String roastType, int volumeMl,
                           double basePrice, String milkType,
                           int syrupPumps) {
        super(roastType, volumeMl, basePrice);

        this.milkType = milkType;
        this.syrupPumps = syrupPumps;
    }

    @Override
    public double calculateCalories() {
        double calories = super.calculateCalories();

        // Умовна модель: молоко додає 30 ккал на 100 мл
        calories += getVolumeMl() * 0.3;

        // Один натискання сиропу — 20 ккал
        calories += syrupPumps * 20;

        return calories;
    }

    @Override
    public double calculatePrice() {
        double price = super.calculatePrice();

        if (milkType.equalsIgnoreCase("рослинне")) {
            price += 20;
        }

        price += syrupPumps * 12;

        return price;
    }

    @Override
    public String toString() {
        return "========== ЧЕК КАВ'ЯРНІ =========="
                + "\nНапій: Лате"
                + "\nОбсмаження: " + getRoastType()
                + "\nОб'єм: " + getVolumeMl() + " мл"
                + "\nМолоко: " + milkType
                + "\nСироп: " + syrupPumps + " натискань"
                + "\nКалорійність: " + calculateCalories() + " ккал"
                + "\nДо сплати: " + calculatePrice() + " грн"
                + "\n=================================";
    }
}