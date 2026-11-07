package semester1.practice08;

public class Task_11 {
    public static void main(String[] args) {
        PassengerCar car = new PassengerCar(
                "Toyota", 220, 50, 5
        );

        CargoTruck truck = new CargoTruck(
                "Volvo", 140, 300, 20
        );

        System.out.println(car);
        System.out.println(truck);

        System.out.println("Витрата пального вантажівки: "
                + truck.calculateFuelConsumption() + " л/100 км");
    }
}

class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected double fuelTankCapacity;

    public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public String toString() {
        return "Марка: " + brand
                + ", максимальна швидкість: " + maxSpeed + " км/год"
                + ", об'єм бака: " + fuelTankCapacity + " л";
    }
}

class PassengerCar extends Vehicle {
    private int passengerSeats;

    public PassengerCar(String brand, int maxSpeed,
                        double fuelTankCapacity, int passengerSeats) {
        super(brand, maxSpeed, fuelTankCapacity);

        this.passengerSeats = passengerSeats;
    }

    @Override
    public String toString() {
        return "Легковий автомобіль: " + super.toString()
                + ", кількість пасажирських місць: " + passengerSeats;
    }
}

class CargoTruck extends Vehicle {
    private double maxLoadTons;

    public CargoTruck(String brand, int maxSpeed,
                      double fuelTankCapacity, double maxLoadTons) {
        super(brand, maxSpeed, fuelTankCapacity);

        this.maxLoadTons = maxLoadTons;
    }

    public double calculateFuelConsumption() {
        // Умовна модель: 25 л на 100 км + 2 л за кожну тонну вантажу
        return 25 + maxLoadTons * 2;
    }

    @Override
    public String toString() {
        return "Вантажівка: " + super.toString()
                + ", вантажопідйомність: " + maxLoadTons + " тонн";
    }
}
