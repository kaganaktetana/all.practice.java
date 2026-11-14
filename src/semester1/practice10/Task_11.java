
package semester1.practice10;

interface Flyable {
    void takeOff();

    double getMaxAltitude();
}

interface Swimmable {
    void dive(double depthMeters);

    double getMaxDepth();
}

interface GpsTrackable {
    String getCoordinates();
}

class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable {

    @Override
    public void takeOff() {
        System.out.println("Дрон злітає в повітря");
    }

    @Override
    public double getMaxAltitude() {
        return 500.0;
    }

    @Override
    public void dive(double depthMeters) {
        System.out.println("Дрон занурився на глибину "
                + depthMeters + " метрів");
    }

    @Override
    public double getMaxDepth() {
        return 50.0;
    }

    @Override
    public String getCoordinates() {
        return "49.8397, 24.0297";
    }
}

abstract class Task_11 {

    public static void testFlight(Flyable f) {
        f.takeOff();
        System.out.println("Максимальна висота: "
                + f.getMaxAltitude() + " м");
    }

    public static void testDiving(Swimmable s) {
        s.dive(20);
        System.out.println("Максимальна глибина: "
                + s.getMaxDepth() + " м");
    }

    public static void logPosition(GpsTrackable g) {
        System.out.println("Координати: " + g.getCoordinates());
    }

    public static void main(String[] args) {

        AmphibiousRescueDrone drone = new AmphibiousRescueDrone();

        testFlight(drone);
        System.out.println();

        testDiving(drone);
        System.out.println();

        logPosition(drone);
    }
}
