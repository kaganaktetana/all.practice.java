package semester1.practice10;

interface PowerProducer {
    double produceMw();
}

interface WeatherDependent {
    void updateWeatherCondition(double factor);
}

abstract class AbstractPowerStation implements PowerProducer {
    private final String stationId;

    public AbstractPowerStation(String stationId) {
        this.stationId = stationId;
    }

    public String getStationId() {
        return stationId;
    }

    public final double getNetOutputMw() {
        return produceMw() * 0.95;
    }
}

class NuclearStation extends AbstractPowerStation {
    private final double capacity;

    public NuclearStation(String stationId, double capacity) {
        super(stationId);
        this.capacity = capacity;
    }

    @Override
    public double produceMw() {
        return capacity;
    }
}

class SolarFarmStation extends AbstractPowerStation
        implements WeatherDependent {

    private double capacity;
    private double weatherFactor = 1.0;

    public SolarFarmStation(String stationId, double capacity) {
        super(stationId);
        this.capacity = capacity;
    }

    @Override
    public void updateWeatherCondition(double factor) {
        weatherFactor = Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() {
        return capacity * weatherFactor;
    }
}

class HydroDamStation extends AbstractPowerStation
        implements WeatherDependent {

    private double capacity;
    private double weatherFactor = 1.0;

    public HydroDamStation(String stationId, double capacity) {
        super(stationId);
        this.capacity = capacity;
    }

    @Override
    public void updateWeatherCondition(double factor) {
        weatherFactor = Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() {
        return capacity * weatherFactor;
    }
}

abstract class Task_37 {

    public static void main(String[] args) {
        PowerProducer[] stations = {
                new NuclearStation("NUC-01", 1000),
                new SolarFarmStation("SOL-01", 300),
                new HydroDamStation("HYD-01", 500)
        };

        double[] weatherFactors = {1.0, 0.7, 0.85};

        double totalGeneration = 0;

        for (int i = 0; i < stations.length; i++) {
            PowerProducer station = stations[i];

            if (station instanceof WeatherDependent wd) {
                wd.updateWeatherCondition(weatherFactors[i]);
            }

            double production = station.produceMw();
            double netProduction = production * 0.95;

            if (station instanceof AbstractPowerStation powerStation) {
                netProduction = powerStation.getNetOutputMw();

                System.out.println(
                        powerStation.getStationId()
                                + ": генерація = " + production
                                + " МВт, після втрат = "
                                + netProduction + " МВт"
                );
            }

            totalGeneration += netProduction;
        }

        System.out.println(
                "Загальна генерація мережі: "
                        + totalGeneration + " МВт"
        );
    }
}