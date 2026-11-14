
package semester1.practice10;

interface Switchable {
    void turnOn();

    void turnOff();
}

interface Dimmable {
    void setBrightness(int percent);
}

interface HeatingCapable {
    void setTargetTemperature(double celsius);
}

abstract class AbstractSmartAppliance {
    private final String room;
    private final String model;
    protected boolean poweredOn;

    public AbstractSmartAppliance(String room, String model) {
        this.room = room;
        this.model = model;
        this.poweredOn = false;
    }

    public String getRoom() {
        return room;
    }

    public String getModel() {
        return model;
    }

    public abstract double getCurrentWatts();
}

class SmartLedChandelier extends AbstractSmartAppliance
        implements Dimmable, Switchable {

    private int brightness;

    public SmartLedChandelier(String room, String model) {
        super(room, model);
        brightness = 100;
    }

    @Override
    public void setBrightness(int percent) {
        if (percent >= 0 && percent <= 100) {
            brightness = percent;
        }
    }

    @Override
    public void turnOn() {
        poweredOn = true;
    }

    @Override
    public void turnOff() {
        poweredOn = false;
    }

    @Override
    public double getCurrentWatts() {
        return poweredOn ? 50.0 * brightness / 100.0 : 0;
    }
}

class SmartUnderfloorHeating extends AbstractSmartAppliance
        implements HeatingCapable, Switchable {

    private double targetTemperature;

    public SmartUnderfloorHeating(String room, String model) {
        super(room, model);
        targetTemperature = 20;
    }

    @Override
    public void setTargetTemperature(double celsius) {
        targetTemperature = celsius;
    }

    @Override
    public void turnOn() {
        poweredOn = true;
    }

    @Override
    public void turnOff() {
        poweredOn = false;
    }

    @Override
    public double getCurrentWatts() {
        return poweredOn ? 1000.0 : 0;
    }
}

abstract class Task_18 {

    public static void main(String[] args) {

        SmartLedChandelier chandelier =
                new SmartLedChandelier("Вітальня", "LED-100");

        SmartUnderfloorHeating heating =
                new SmartUnderfloorHeating("Ванна", "Heat-200");

        chandelier.turnOn();
        chandelier.setBrightness(80);

        heating.turnOn();
        heating.setTargetTemperature(25);

        AbstractSmartAppliance[] appliances = {
                chandelier,
                heating
        };

        double totalWatts = 0;

        for (AbstractSmartAppliance appliance : appliances) {

            System.out.println(appliance.getModel()
                    + " (" + appliance.getRoom() + "): "
                    + appliance.getCurrentWatts() + " Вт");

            totalWatts += appliance.getCurrentWatts();
        }

        System.out.println("Загальне споживання: "
                + totalWatts + " Вт");
    }
}
