
package semester1.practice10;

abstract class IndustrialAsset {
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;

    public IndustrialAsset(String name, double initialCost,
                           int usefulLifeYears) {
        this.name = name;
        this.initialCost = initialCost;
        this.usefulLifeYears = usefulLifeYears;

        if (initialCost < 0 || usefulLifeYears <= 0) {
            throw new IllegalArgumentException("Некоректні дані");
        }
    }

    public String getName() {
        return name;
    }

    public abstract double getBookValueAfterYears(int years);
}

class LinearDepreciationAsset extends IndustrialAsset {

    public LinearDepreciationAsset(String name, double initialCost,
                                   int usefulLifeYears) {
        super(name, initialCost, usefulLifeYears);
    }

    @Override
    public double getBookValueAfterYears(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Роки не можуть бути від'ємними");
        }

        double value = initialCost *
                (1.0 - (double) years / usefulLifeYears);

        return Math.max(0, value);
    }
}

class DecliningBalanceAsset extends IndustrialAsset {
    private final double rate;

    public DecliningBalanceAsset(String name, double initialCost,
                                 int usefulLifeYears, double rate) {
        super(name, initialCost, usefulLifeYears);

        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Rate має бути від 0 до 1");
        }

        this.rate = rate;
    }

    @Override
    public double getBookValueAfterYears(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Роки не можуть бути від'ємними");
        }

        return initialCost * Math.pow(1 - rate, years);
    }
}

public class Task_08 {

    public static void main(String[] args) {

        IndustrialAsset[] assets = {
                new LinearDepreciationAsset("Верстат", 100000, 10),
                new LinearDepreciationAsset("Конвеєр", 200000, 20),
                new DecliningBalanceAsset("Робот", 150000, 10, 0.2),
                new DecliningBalanceAsset("Прес", 80000, 8, 0.15)
        };

        int years = 3;
        double totalValue = 0;

        for (IndustrialAsset asset : assets) {
            double value = asset.getBookValueAfterYears(years);

            System.out.println(
                    asset.getName() + ": " + value + " грн"
            );

            totalValue += value;
        }

        System.out.println("Сумарна залишкова вартість: "
                + totalValue + " грн");
    }
}
