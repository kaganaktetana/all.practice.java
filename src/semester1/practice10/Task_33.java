package semester1.practice10;

import java.util.Arrays;

class FinalCalibrationTable {
    public static final double GRAVITY_G = 9.80665;

    private final String sensorSerial;
    private final double[] coefficients;

    public FinalCalibrationTable(String sensorSerial, double[] coefficients) {
        this.sensorSerial = sensorSerial;
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    public String getSensorSerial() {
        return sensorSerial;
    }

    public double[] getCoefficients() {
        return Arrays.copyOf(coefficients, coefficients.length);
    }
}

abstract class Task_33 {

    public static void main(String[] args) {
        double[] originalCoefficients = {1.5, 2.5, 3.5};

        FinalCalibrationTable table =
                new FinalCalibrationTable("SENSOR-001", originalCoefficients);

        System.out.println("Серійний номер: " + table.getSensorSerial());
        System.out.println("Гравітація: " + FinalCalibrationTable.GRAVITY_G);

        System.out.println(
                "Коефіцієнти: "
                        + Arrays.toString(table.getCoefficients())
        );

        originalCoefficients[0] = 999;

        double[] receivedCoefficients = table.getCoefficients();
        receivedCoefficients[1] = 999;

        System.out.println(
                "Після спроби зміни: "
                        + Arrays.toString(table.getCoefficients())
        );
    }
}