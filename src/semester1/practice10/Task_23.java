
package semester1.practice10;

abstract class AbstractLabDevice {
    private final String inventoryCode;

    public AbstractLabDevice(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public abstract void performMeasurement();
}

interface Calibratable {
    void calibrate(double referenceValue);
}

interface SelfDiagnostic {
    boolean runSelfCheck();
}

class ElectronicScale extends AbstractLabDevice
        implements Calibratable, SelfDiagnostic {

    private double weight;

    public ElectronicScale(String inventoryCode) {
        super(inventoryCode);
    }

    @Override
    public void performMeasurement() {
        weight = 75.5;
        System.out.println("Виміряна вага: " + weight + " кг");
    }

    @Override
    public void calibrate(double referenceValue) {
        weight = referenceValue;
        System.out.println("Ваги відкалібровано: "
                + referenceValue + " кг");
    }

    @Override
    public boolean runSelfCheck() {
        return true;
    }
}

class GlassThermometer extends AbstractLabDevice {

    public GlassThermometer(String inventoryCode) {
        super(inventoryCode);
    }

    @Override
    public void performMeasurement() {
        System.out.println("Температура: 36.6 °C");
    }
}

abstract class Task_23 {

    public static void main(String[] args) {

        AbstractLabDevice[] devices = {
                new ElectronicScale("SCALE-001"),
                new GlassThermometer("THERMO-002")
        };

        for (AbstractLabDevice device : devices) {

            System.out.println("Прилад: " + device.getInventoryCode());

            device.performMeasurement();

            if (device instanceof Calibratable c) {
                c.calibrate(70.0);
            }

            if (device instanceof SelfDiagnostic s) {
                System.out.println("Самодіагностика: "
                        + s.runSelfCheck());
            }

            System.out.println();
        }
    }
}
