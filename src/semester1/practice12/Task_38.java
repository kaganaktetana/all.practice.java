
package semester1.practice12;

import java.util.*;

public class Task_38 {

    static final class TradeOrder {
        private final String orderId;
        private final String pair;
        private final double price;
        private final double volume;

        public TradeOrder(
                String orderId,
                String pair,
                double price,
                double volume) {

            this.orderId = orderId;
            this.pair = pair;
            this.price = price;
            this.volume = volume;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getPair() {
            return pair;
        }

        public double getPrice() {
            return price;
        }

        public double getVolume() {
            return volume;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TradeOrder order)) return false;

            return Objects.equals(orderId, order.orderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId);
        }

        @Override
        public String toString() {
            return orderId + " | " + pair
                    + " | Price: " + price
                    + " | Volume: " + volume;
        }
    }

    public static void main(String[] args) {

        Set<String> binancePairs = new HashSet<>(
                Arrays.asList(
                        "BTC/USDT", "ETH/USDT",
                        "SOL/USDT", "XRP/USDT"));

        Set<String> krakenPairs = new HashSet<>(
                Arrays.asList(
                        "BTC/USDT", "ETH/USDT",
                        "ADA/USDT", "DOT/USDT"));

        // Перетин
        Set<String> commonPairs =
                new HashSet<>(binancePairs);

        commonPairs.retainAll(krakenPairs);

        // Симетрична різниця
        Set<String> exclusivePairs =
                new HashSet<>(binancePairs);

        exclusivePairs.addAll(krakenPairs);

        Set<String> intersection =
                new HashSet<>(binancePairs);

        intersection.retainAll(krakenPairs);

        exclusivePairs.removeAll(intersection);

        System.out.println("=== АРБІТРАЖНІ ПАРИ ===");
        System.out.println(commonPairs);

        System.out.println("\n=== ЕКСКЛЮЗИВНІ ПАРИ ===");
        System.out.println(exclusivePairs);

        List<TradeOrder> orders = new ArrayList<>();

        orders.add(new TradeOrder(
                "O-01", "BTC/USDT", 65000, 0.5));

        orders.add(new TradeOrder(
                "O-02", "ETH/USDT", 3500, 2));

        orders.add(new TradeOrder(
                "O-03", "SOL/USDT", 150, 10));

        orders.add(new TradeOrder(
                "O-04", "ADA/USDT", 0.5, 100));

        orders.add(new TradeOrder(
                "O-05", "BTC/USDT", 65000, -1));

        orders.add(new TradeOrder(
                "O-06", "ETH/USDT", 3500, 3));

        double liquidity = 0;

        Iterator<TradeOrder> it = orders.iterator();

        while (it.hasNext()) {

            TradeOrder order = it.next();

            if (!commonPairs.contains(order.getPair())
                    || order.getVolume() <= 0
                    || order.getPrice() <= 0) {

                System.out.println("Видалено: " + order);
                it.remove();

            } else {

                liquidity += order.getPrice()
                        * order.getVolume();
            }
        }

        System.out.println("\n=== ДІЙСНІ ОРДЕРИ ===");

        for (TradeOrder order : orders) {
            System.out.println(order);
        }

        System.out.println("\nСумарна ліквідність: "
                + liquidity + " USDT");
    }
}
