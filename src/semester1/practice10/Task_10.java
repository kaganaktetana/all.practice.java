
package semester1.practice10;

interface EnergyConvertible {

    double SPEED_OF_LIGHT = 299_792_458.0;
    double JOULES_PER_KWH = 3_600_000.0;

    double getEnergyJoules();

    default double getEnergyKwh() {
        return getEnergyJoules() / JOULES_PER_KWH;
    }
}

class KineticBody implements EnergyConvertible {
    private final double mass;
    private final double velocity;

    public KineticBody(double mass, double velocity) {
        this.mass = mass;
        this.velocity = velocity;
    }

    @Override
    public double getEnergyJoules() {
        return 0.5 * mass * velocity * velocity;
    }
}

class BatteryCell implements EnergyConvertible {
    private final double capacityWh;

    public BatteryCell(double capacityWh) {
        this.capacityWh = capacityWh;
    }

    @Override
    public double getEnergyJoules() {
        return capacityWh * 3600;
    }
}

public class Task_10 {

    public static void main(String[] args) {

        EnergyConvertible[] devices = {
                new KineticBody(10, 20),
                new BatteryCell(500)
        };

        for (EnergyConvertible device : devices) {

            System.out.println(
                    "Енергія: " + device.getEnergyJoules() + " Дж"
            );

            System.out.println(
                    "Енергія: " + device.getEnergyKwh() + " кВт·год"
            );

            System.out.println();
        }
    }
}
