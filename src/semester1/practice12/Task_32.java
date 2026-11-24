
package semester1.practice12;

import java.util.*;

public class Task_32 {

    interface Calibratable {
        void calibrate();
    }

    abstract static class AbstractSensor {
        private final String sensorId;
        private boolean active;

        public AbstractSensor(String sensorId, boolean active) {
            this.sensorId = sensorId;
            this.active = active;
        }

        public String getSensorId() {
            return sensorId;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AbstractSensor sensor)) return false;
            return Objects.equals(sensorId, sensor.sensorId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sensorId);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName()
                    + " [" + sensorId + ", active=" + active + "]";
        }
    }

    static class TempSensor extends AbstractSensor
            implements Calibratable {

        public TempSensor(String id, boolean active) {
            super(id, active);
        }

        @Override
        public void calibrate() {
            System.out.println("Калібрування температурного датчика "
                    + getSensorId());
        }
    }

    static class MotionSensor extends AbstractSensor
            implements Calibratable {

        public MotionSensor(String id, boolean active) {
            super(id, active);
        }

        @Override
        public void calibrate() {
            System.out.println("Калібрування датчика руху "
                    + getSensorId());
        }
    }

    static class SmokeSensor extends AbstractSensor {

        public SmokeSensor(String id, boolean active) {
            super(id, active);
        }
    }

    static class SmartHomeHub
            implements Iterable<AbstractSensor> {

        private final Set<AbstractSensor> sensors =
                new LinkedHashSet<>();

        public void addSensor(AbstractSensor sensor) {
            sensors.add(sensor);
        }

        public int removeOfflineSensors() {
            int removed = 0;

            Iterator<AbstractSensor> it = sensors.iterator();

            while (it.hasNext()) {
                AbstractSensor sensor = it.next();

                if (!sensor.isActive()) {
                    System.out.println("Видалено: " + sensor);
                    it.remove();
                    removed++;
                }
            }

            return removed;
        }

        public void calibrateAllSupported() {
            for (AbstractSensor sensor : sensors) {

                if (sensor instanceof Calibratable c) {
                    c.calibrate();
                } else {
                    System.out.println(
                            sensor.getSensorId()
                                    + " не підтримує калібрування"
                    );
                }
            }
        }

        @Override
        public Iterator<AbstractSensor> iterator() {
            return Collections.unmodifiableSet(sensors).iterator();
        }
    }

    public static void main(String[] args) {

        SmartHomeHub hub = new SmartHomeHub();

        hub.addSensor(new TempSensor("TEMP-01", true));
        hub.addSensor(new MotionSensor("MOTION-01", true));
        hub.addSensor(new SmokeSensor("SMOKE-01", false));
        hub.addSensor(new TempSensor("TEMP-02", false));
        hub.addSensor(new SmokeSensor("SMOKE-02", true));

        System.out.println("=== УСІ ДАТЧИКИ ===");

        for (AbstractSensor sensor : hub) {
            System.out.println(sensor);
        }

        System.out.println("\n=== КАЛІБРУВАННЯ ===");
        hub.calibrateAllSupported();

        System.out.println("\n=== ВИДАЛЕННЯ НЕАКТИВНИХ ===");

        int removed = hub.removeOfflineSensors();

        System.out.println("Видалено датчиків: " + removed);

        System.out.println("\n=== АКТИВНІ ДАТЧИКИ ===");

        for (AbstractSensor sensor : hub) {
            System.out.println(sensor);
        }
    }
}
