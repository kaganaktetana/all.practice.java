
package semester1.practice10;

abstract class AbstractVehicle {
    private final String plateNumber;
    protected double mileageKm;

    public AbstractVehicle(String plateNumber, double mileageKm) {
        this.plateNumber = plateNumber;
        this.mileageKm = mileageKm;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getMileageKm() {
        return mileageKm;
    }
}

interface CargoCarrier {
    double getMaxPayloadTons();
}

interface PassengerCarrier {
    int getSeatCount();
}

interface ElectricPowered {
    double getBatteryCapacityKwh();
}

class ElectricCityBus extends AbstractVehicle
        implements PassengerCarrier, ElectricPowered {

    public ElectricCityBus(String plateNumber, double mileageKm) {
        super(plateNumber, mileageKm);
    }

    @Override
    public int getSeatCount() {
        return 40;
    }

    @Override
    public double getBatteryCapacityKwh() {
        return 350;
    }
}

class DieselDumpTruck extends AbstractVehicle
        implements CargoCarrier {

    public DieselDumpTruck(String plateNumber, double mileageKm) {
        super(plateNumber, mileageKm);
    }

    @Override
    public double getMaxPayloadTons() {
        return 25;
    }
}

class CargoPassengerVan extends AbstractVehicle
        implements CargoCarrier, PassengerCarrier {

    public CargoPassengerVan(String plateNumber, double mileageKm) {
        super(plateNumber, mileageKm);
    }

    @Override
    public double getMaxPayloadTons() {
        return 1.5;
    }

    @Override
    public int getSeatCount() {
        return 8;
    }
}

abstract class Task_21 {

    public static void main(String[] args) {

        AbstractVehicle[] vehicles = {
                new ElectricCityBus("AA1234BB", 15000),
                new DieselDumpTruck("BC5678CC", 85000),
                new CargoPassengerVan("KA1111AA", 30000)
        };

        for (AbstractVehicle vehicle : vehicles) {

            System.out.println("Номер: " + vehicle.getPlateNumber());
            System.out.println("Пробіг: " + vehicle.getMileageKm() + " км");

            if (vehicle instanceof PassengerCarrier p) {
                System.out.println("Кількість місць: " + p.getSeatCount());
            }

            if (vehicle instanceof CargoCarrier c) {
                System.out.println("Вантажопідйомність: "
                        + c.getMaxPayloadTons() + " т");
            }

            if (vehicle instanceof ElectricPowered e) {
                System.out.println("Батарея: "
                        + e.getBatteryCapacityKwh() + " кВт·год");
            }

            System.out.println();
        }
    }
}
