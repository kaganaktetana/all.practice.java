
package semester1.practice10;

interface Measurable {
    double getMeasure();
}

class BankVault implements Measurable {
    private final double goldKg;

    public BankVault(double goldKg) {
        this.goldKg = goldKg;
    }

    @Override
    public double getMeasure() {
        return goldKg;
    }
}

class HighwayRoute implements Measurable {
    private final double lengthKm;

    public HighwayRoute(double lengthKm) {
        this.lengthKm = lengthKm;
    }

    @Override
    public double getMeasure() {
        return lengthKm;
    }
}

class CpuCore implements Measurable {
    private final double frequencyGhz;

    public CpuCore(double frequencyGhz) {
        this.frequencyGhz = frequencyGhz;
    }

    @Override
    public double getMeasure() {
        return frequencyGhz;
    }
}

public class Task_09 {

    public static double computeAverage(Measurable[] items) {

        if (items == null || items.length == 0) {
            return 0;
        }

        double sum = 0;

        for (Measurable item : items) {
            sum += item.getMeasure();
        }

        return sum / items.length;
    }

    public static void main(String[] args) {

        Measurable[] items = {
                new BankVault(500),
                new HighwayRoute(250),
                new CpuCore(4.5)
        };

        System.out.println("Середнє значення: "
                + computeAverage(items));
    }
}
