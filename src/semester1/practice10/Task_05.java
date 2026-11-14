
package semester1.practice10;

abstract class ShippingTariff {

    public abstract double calculateCost(
            double weightKg,
            double distanceKm
    );
}

class RoadTruckTariff extends ShippingTariff {

    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 15.0 * distanceKm + 2.5 * weightKg;
    }
}

class AirCargoTariff extends ShippingTariff {

    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 45.0 * distanceKm + 18.0 * weightKg + 500.0;
    }
}

class RailFreightTariff extends ShippingTariff {

    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 1200.0 + 4.0 * distanceKm + 0.8 * weightKg;
    }
}

public class Task_05 {

    public static void main(String[] args) {

        ShippingTariff[] tariffs = {
                new RoadTruckTariff(),
                new AirCargoTariff(),
                new RailFreightTariff()
        };

        double weightKg = 250;
        double distanceKm = 600;

        ShippingTariff bestTariff = tariffs[0];
        double minCost = bestTariff.calculateCost(weightKg, distanceKm);

        for (ShippingTariff tariff : tariffs) {

            double cost = tariff.calculateCost(weightKg, distanceKm);

            System.out.println(
                    tariff.getClass().getSimpleName()
                            + ": " + cost + " грн"
            );

            if (cost < minCost) {
                minCost = cost;
                bestTariff = tariff;
            }
        }

        System.out.println();
        System.out.println("Найвигідніший тариф: "
                + bestTariff.getClass().getSimpleName());

        System.out.println("Вартість доставки: " + minCost + " грн");
    }
}
