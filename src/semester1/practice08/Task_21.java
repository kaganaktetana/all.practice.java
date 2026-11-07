package semester1.practice08;

public class Task_21 {
    public static void main(String[] args) {
        Parcel parcel = new Parcel("UA123456789", 5.0);

        FragileParcel fragile = new FragileParcel(
                "UA987654321", 8.0, true, 2000
        );

        System.out.println(parcel);
        System.out.println();
        System.out.println(fragile);
    }
}

class Parcel {
    private String trackingCode;
    private double weightKg;

    public Parcel(String trackingCode, double weightKg) {
        this.trackingCode = trackingCode;
        this.weightKg = weightKg;
    }

    public double calculateShippingCost() {
        return 50.0 + weightKg * 12.0;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public String toString() {
        return "Посилка: " + trackingCode
                + ", вага: " + weightKg + " кг"
                + ", доставка: " + calculateShippingCost() + " грн";
    }
}

class FragileParcel extends Parcel {
    private boolean requiresWoodenBox;
    private double insuranceValue;

    public FragileParcel(String trackingCode, double weightKg,
                         boolean requiresWoodenBox, double insuranceValue) {
        super(trackingCode, weightKg);

        this.requiresWoodenBox = requiresWoodenBox;
        this.insuranceValue = insuranceValue;
    }

    @Override
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();

        cost += insuranceValue * 0.015;

        if (requiresWoodenBox) {
            cost += 120.0;
        }

        return cost;
    }

    @Override
    public String toString() {
        return "Крихка посилка: " + getTrackingCode()
                + ", вага: " + getWeightKg() + " кг"
                + ", страхова вартість: " + insuranceValue + " грн"
                + ", дерев'яна обрешітка: "
                + (requiresWoodenBox ? "так" : "ні")
                + ", вартість доставки: "
                + calculateShippingCost() + " грн";
    }
}