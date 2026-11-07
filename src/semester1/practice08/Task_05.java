
package semester1.practice08;

public class Task_05 {

    public static void main(String[] args) {

        SensorNode sensor = new SensorNode(
                "TEMP-001",
                23.5,
                1.2
        );

        System.out.println(sensor);

        System.out.println("ID датчика: " + sensor.getSensorId());
        System.out.println("Відкаліброване значення: "
                + sensor.getCalibratedValue());
    }
}

class SensorNode {

    private String sensorId;
    protected double calibrationOffset;
    private double rawValue;

    public SensorNode(String sensorId, double rawValue,
                      double calibrationOffset) {

        this.sensorId = sensorId;
        this.rawValue = rawValue;
        this.calibrationOffset = calibrationOffset;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getCalibratedValue() {
        return rawValue + calibrationOffset;
    }

    @Override
    public String toString() {
        return String.format(
                "SensorNode{id='%s', rawValue=%.2f, calibratedValue=%.2f}",
                sensorId, rawValue, getCalibratedValue()
        );
    }
}

