package semester1.practice12;

import java.util.*;

public class Task_15 {

    static class ServerNode implements Comparable<ServerNode> {
        private final String hostName;
        private final int pingMs;
        private final double cpuLoad;

        public ServerNode(String hostName, int pingMs, double cpuLoad) {
            this.hostName = hostName;
            this.pingMs = pingMs;
            this.cpuLoad = cpuLoad;
        }

        @Override
        public int compareTo(ServerNode other) {
            int result = Integer.compare(this.pingMs, other.pingMs);

            if (result == 0) {
                result = this.hostName.compareTo(other.hostName);
            }

            return result;
        }

        @Override
        public String toString() {
            return hostName
                    + " | Ping: " + pingMs + " ms"
                    + " | CPU: " + cpuLoad + "%";
        }
    }

    public static void main(String[] args) {
        TreeSet<ServerNode> naturalOrder = new TreeSet<>();

        naturalOrder.add(new ServerNode("Server-A", 40, 75.5));
        naturalOrder.add(new ServerNode("Server-B", 20, 45.0));
        naturalOrder.add(new ServerNode("Server-C", 60, 90.0));
        naturalOrder.add(new ServerNode("Server-D", 20, 30.0));
        naturalOrder.add(new ServerNode("Server-E", 35, 55.0));

        TreeSet<ServerNode> cpuOrder = new TreeSet<>(
                Comparator.comparingDouble(
                        (ServerNode s) -> s.cpuLoad
                ).reversed().thenComparing(s -> s.hostName)
        );

        cpuOrder.addAll(naturalOrder);

        System.out.println("=== Сортування за Ping ===");

        for (ServerNode server : naturalOrder) {
            System.out.println(server);
        }

        System.out.println("\n=== Сортування за CPU (спадання) ===");

        for (ServerNode server : cpuOrder) {
            System.out.println(server);
        }
    }
}
