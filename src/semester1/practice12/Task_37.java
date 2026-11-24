
package semester1.practice12;

import java.util.*;

public class Task_37 {

    interface InternationalFlight {
        String getDestinationCountry();
    }

    abstract static class AbstractFlight {
        private final String flightCode;
        private final int delayMinutes;

        public AbstractFlight(String flightCode, int delayMinutes) {
            this.flightCode = flightCode;
            this.delayMinutes = delayMinutes;
        }

        public String getFlightCode() {
            return flightCode;
        }

        public int getDelayMinutes() {
            return delayMinutes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof AbstractFlight flight)) return false;

            return Objects.equals(flightCode, flight.flightCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(flightCode);
        }

        @Override
        public String toString() {
            return flightCode + " | Затримка: "
                    + delayMinutes + " хв";
        }
    }

    static class DomesticFlight extends AbstractFlight {

        public DomesticFlight(String code, int delay) {
            super(code, delay);
        }
    }

    static class InternationalCharterFlight
            extends AbstractFlight
            implements InternationalFlight {

        private final String destinationCountry;

        public InternationalCharterFlight(
                String code,
                int delay,
                String country) {

            super(code, delay);
            this.destinationCountry = country;
        }

        @Override
        public String getDestinationCountry() {
            return destinationCountry;
        }
    }

    public static void main(String[] args) {

        Set<AbstractFlight> schedule = new LinkedHashSet<>();

        schedule.add(new DomesticFlight("PS-101", 30));
        schedule.add(new InternationalCharterFlight(
                "UIA-205", 60, "Poland"));

        schedule.add(new DomesticFlight("PS-102", 210));

        schedule.add(new InternationalCharterFlight(
                "CH-301", 45, "Germany"));

        schedule.add(new InternationalCharterFlight(
                "CH-302", 190, "France"));

        schedule.add(new InternationalCharterFlight(
                "CH-303", 90, "Poland"));

        System.out.println("=== ПОЧАТКОВИЙ РОЗКЛАД ===");

        for (AbstractFlight flight : schedule) {
            System.out.println(flight);
        }

        // Видалення рейсів із затримкою понад 180 хв
        Iterator<AbstractFlight> it = schedule.iterator();

        while (it.hasNext()) {

            AbstractFlight flight = it.next();

            if (flight.getDelayMinutes() > 180) {
                System.out.println("Скасовано: " + flight);
                it.remove();
            }
        }

        // Пошук унікальних країн
        TreeSet<String> countries = new TreeSet<>();

        for (AbstractFlight flight : schedule) {

            if (flight instanceof InternationalFlight international) {
                countries.add(
                        international.getDestinationCountry());
            }
        }

        System.out.println("\n=== АКТИВНІ РЕЙСИ ===");

        for (AbstractFlight flight : schedule) {
            System.out.println(flight);
        }

        System.out.println("\nКраїни призначення:");
        System.out.println(countries);
    }
}
