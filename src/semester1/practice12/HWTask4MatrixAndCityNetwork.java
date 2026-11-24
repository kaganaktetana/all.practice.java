
package semester1.practice12;

import java.util.*;

// ================= TRANSPORT =================

abstract class Transport {
    private final String name;
    private final double speedKmH;

    public Transport(String name, double speedKmH) {
        this.name = name;
        this.speedKmH = speedKmH;
    }

    public String getName() {
        return name;
    }

    public double getSpeedKmH() {
        return speedKmH;
    }

    public double calculateTimeHours(int distanceKm) {
        return distanceKm / speedKmH;
    }

    public abstract double calculateCostUah(int distanceKm);
}

// ================= BUS =================

class Bus extends Transport {
    public Bus() {
        super("Bus", 80.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 2.5;
    }
}

// ================= TRAIN =================

class Train extends Transport {
    public Train() {
        super("Train", 100.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 1.8 + 150.0;
    }
}

// ================= DELIVERY TRUCK =================

class DeliveryTruck extends Transport {
    public DeliveryTruck() {
        super("DeliveryTruck", 70.0);
    }

    @Override
    public double calculateCostUah(int distanceKm) {
        return distanceKm * 4.0 + 300.0;
    }
}

// ================= TRIP ORDER =================

class TripOrder {
    private final String orderId;
    private final String fromCity;
    private final String toCity;
    private final Transport transport;

    public TripOrder(String orderId, String fromCity,
                     String toCity, Transport transport) {
        this.orderId = orderId;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.transport = transport;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TripOrder order)) return false;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}

// ================= ROUTE DISPATCHER =================

class RouteDispatcher {
    private final ArrayList<String> cities;
    private final int[][] distances;
    private final HashSet<String> closedCities;
    private final ArrayList<TripOrder> orders;

    public RouteDispatcher(ArrayList<String> cities,
                           int[][] distances,
                           HashSet<String> closedCities) {

        this.cities = new ArrayList<>(cities);

        this.distances = new int[distances.length][];

        for (int i = 0; i < distances.length; i++) {
            this.distances[i] = distances[i].clone();
        }

        this.closedCities = new HashSet<>(closedCities);
        this.orders = new ArrayList<>();
    }

    public void addOrder(TripOrder order) {
        orders.add(order);
    }

    public int getDistance(String from, String to) {
        int i = cities.indexOf(from);
        int j = cities.indexOf(to);

        if (i == -1 || j == -1) {
            return 0;
        }

        return distances[i][j];
    }

    public HashSet<String> getDirectNeighbors(String city) {
        HashSet<String> neighbors = new HashSet<>();

        int index = cities.indexOf(city);

        if (index == -1) {
            return neighbors;
        }

        for (int j = 0; j < distances[index].length; j++) {
            if (distances[index][j] > 0) {
                neighbors.add(cities.get(j));
            }
        }

        return neighbors;
    }

    public HashSet<String> getCommonNeighbors(
            String cityA, String cityB) {

        HashSet<String> result = getDirectNeighbors(cityA);

        result.retainAll(getDirectNeighbors(cityB));

        return result;
    }

    public HashSet<String> getExclusiveNeighbors(
            String cityA, String cityB) {

        HashSet<String> result = getDirectNeighbors(cityA);

        result.removeAll(getDirectNeighbors(cityB));

        return result;
    }

    public int filterInvalidOrders() {
        HashSet<String> seenIds = new HashSet<>();

        Iterator<TripOrder> it = orders.iterator();

        int removed = 0;

        while (it.hasNext()) {
            TripOrder order = it.next();

            String id = order.getOrderId();
            String from = order.getFromCity();
            String to = order.getToCity();

            // Перевірка дублікатів
            if (!seenIds.add(id)) {
                System.out.printf(
                        "  ❌ [ДУБЛІКАТ]       %s (%s -> %s) — видалено!%n",
                        id, from, to
                );

                it.remove();
                removed++;
            }

            // Перевірка закритих міст
            else if (closedCities.contains(from)
                    || closedCities.contains(to)) {

                System.out.printf(
                        "  ❌ [МІСТО ЗАКРИТЕ]  %s (%s -> %s) — видалено!%n",
                        id, from, to
                );

                it.remove();
                removed++;
            }

            // Перевірка наявності дороги
            else if (getDistance(from, to) <= 0) {

                System.out.printf(
                        "  ❌ [НЕМАЄ ДОРОГИ]   %s (%s -> %s) — видалено!%n",
                        id, from, to
                );

                it.remove();
                removed++;
            }
        }

        return removed;
    }

    public void printReport() {
        double totalCost = 0;
        int totalDistance = 0;

        System.out.println(
                "\n--- 3. Схвалені рейси (залишилось "
                        + orders.size() + ") ---"
        );

        for (TripOrder order : orders) {
            int distance = getDistance(
                    order.getFromCity(),
                    order.getToCity()
            );

            Transport transport = order.getTransport();

            double time = transport.calculateTimeHours(distance);
            double cost = transport.calculateCostUah(distance);

            totalDistance += distance;
            totalCost += cost;

            System.out.printf(
                    "  ✅ %-5s | %-8s -> %-8s | %3d км | %-14s | Час: %.2f год | Вартість: %.2f грн%n",
                    order.getOrderId(),
                    order.getFromCity(),
                    order.getToCity(),
                    distance,
                    transport.getName(),
                    time,
                    cost
            );
        }

        System.out.println("\n--- Підсумок ---");

        System.out.println(
                "Схвалено заявок: " + orders.size()
        );

        System.out.println(
                "Загальна відстань: " + totalDistance + " км"
        );

        System.out.printf(
                "Загальна вартість перевезень: %.2f грн%n",
                totalCost
        );
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public HashSet<String> getClosedCitiesCopy() {
        return new HashSet<>(closedCities);
    }
}

// ================= MAIN =================

public class HWTask4MatrixAndCityNetwork {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>(
                List.of("Київ", "Львів", "Одеса", "Дніпро")
        );

        int[][] distances = {
                {0, 540, 480, 450},
                {540, 0, 790, 0},
                {480, 790, 0, 460},
                {450, 0, 460, 0}
        };

        HashSet<String> closedCities = new HashSet<>(
                Set.of("Одеса")
        );

        RouteDispatcher dispatcher =
                new RouteDispatcher(cities, distances, closedCities);

        // Додавання заявок
        dispatcher.addOrder(
                new TripOrder("ORD-1", "Київ", "Львів", new Train())
        );

        dispatcher.addOrder(
                new TripOrder("ORD-1", "Київ", "Львів", new Bus())
        );

        dispatcher.addOrder(
                new TripOrder("ORD-2", "Київ", "Одеса", new Bus())
        );

        dispatcher.addOrder(
                new TripOrder("ORD-3", "Львів", "Дніпро",
                        new DeliveryTruck())
        );

        dispatcher.addOrder(
                new TripOrder("ORD-4", "Київ", "Дніпро",
                        new DeliveryTruck())
        );

        System.out.println(
                "================ 🚚 ЛОГІСТИЧНИЙ ДИСПЕТЧЕР ================"
        );

        // 1. Аналіз мережі
        System.out.println(
                "\n--- 1. Аналіз мережі доріг (2D-масив -> HashSet) ---"
        );

        System.out.println(
                "Прямі сусіди Києва: "
                        + dispatcher.getDirectNeighbors("Київ")
        );

        System.out.println(
                "Прямі сусіди Львова: "
                        + dispatcher.getDirectNeighbors("Львів")
        );

        System.out.println(
                "Спільні сусіди Київ і Львів: "
                        + dispatcher.getCommonNeighbors("Київ", "Львів")
        );

        System.out.println(
                "Тільки з Києва: "
                        + dispatcher.getExclusiveNeighbors("Київ", "Львів")
        );

        // 2. Фільтрація заявок
        System.out.println(
                "\n--- 2. Фільтрація заявок через Iterator.remove() ---"
        );

        System.out.println(
                "Закриті міста: " + dispatcher.getClosedCitiesCopy()
        );

        int removed = dispatcher.filterInvalidOrders();

        // 3. Звіт
        dispatcher.printReport();

        System.out.println(
                "\nВидалено заявок: " + removed
                        + " | Схвалено: " + dispatcher.getOrdersCount()
        );

        System.out.println(
                "=========================================================="
        );
    }
}
