package semester1.practice08;

public class Task_22 {
    public static void main(String[] args) {
        Appliance appliance = new Appliance("Samsung", 2000);

        EcoHeater heater = new EcoHeater(
                "Xiaomi Eco Heater", 2000, true
        );

        System.out.println(appliance);
        System.out.println("Споживання за 5 годин: "
                + appliance.getDailyConsumptionKWh(5) + " кВт·год");

        System.out.println();

        System.out.println(heater);
        System.out.println("Споживання за 5 годин: "
                + heater.getDailyConsumptionKWh(5) + " кВт·год");
    }
}

class Appliance {
    private String model;
    private double powerWatts;

    public Appliance(String model, double powerWatts) {
        this.model = model;
        this.powerWatts = powerWatts;
    }

    public double getDailyConsumptionKWh(int hours) {
        return (powerWatts * hours) / 1000.0;
    }

    public String getModel() {
        return model;
    }

    public double getPowerWatts() {
        return powerWatts;
    }

    @Override
    public String toString() {
        return "Прилад: " + model
                + ", потужність: " + powerWatts + " Вт";
    }
}

class EcoHeater extends Appliance {
    private boolean ecoModeActive;

    public EcoHeater(String model, double powerWatts,
                     boolean ecoModeActive) {
        super(model, powerWatts);

        this.ecoModeActive = ecoModeActive;
    }

    @Override
    public double getDailyConsumptionKWh(int hours) {
        double consumption = super.getDailyConsumptionKWh(hours);

        if (ecoModeActive) {
            consumption *= 0.75;
        }

        return consumption;
    }

    @Override
    public String toString() {
        return "Економний обігрівач: " + getModel()
                + ", потужність: " + getPowerWatts() + " Вт"
                + ", режим ECO: "
                + (ecoModeActive ? "увімкнений" : "вимкнений");
    }
}