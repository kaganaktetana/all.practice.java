package semester1.practice08;

public class Task_26 {
    public static void main(String[] args) {

        ElectricCar car = new ElectricCar(
                "Tesla",
                2025,
                450,
                4,
                100.0,
                550
        );

        System.out.println(car);
    }
}

class BaseVehicle {
    private String brand;
    private int year;

    public BaseVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Марка: " + brand
                + ", рік випуску: " + year;
    }
}

class MotorCar extends BaseVehicle {
    private int horsePower;
    private int doorsCount;

    public MotorCar(String brand, int year,
                    int horsePower, int doorsCount) {

        super(brand, year);

        this.horsePower = horsePower;
        this.doorsCount = doorsCount;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", потужність: " + horsePower + " к.с."
                + ", кількість дверей: " + doorsCount;
    }
}

class ElectricCar extends MotorCar {
    private double batteryCapacityKWh;
    private int rangeKm;

    public ElectricCar(String brand, int year,
                       int horsePower, int doorsCount,
                       double batteryCapacityKWh, int rangeKm) {

        super(brand, year, horsePower, doorsCount);

        this.batteryCapacityKWh = batteryCapacityKWh;
        this.rangeKm = rangeKm;
    }

    @Override
    public String toString() {
        return "Електромобіль: "
                + super.toString()
                + ", ємність батареї: " + batteryCapacityKWh + " кВт·год"
                + ", запас ходу: " + rangeKm + " км";
    }
}