package semester1.practice12;

import java.util.*;

public class Task_03 {

    public static List<String> deduplicatePreserveOrder(
            List<String> input) {

        LinkedHashSet<String> unique = new LinkedHashSet<>(input);

        return new ArrayList<>(unique);
    }

    public static void main(String[] args) {

        List<String> rawLogs = new ArrayList<>(Arrays.asList(
                "192.168.1.10",
                "192.168.1.15",
                "192.168.1.20",
                "192.168.1.10",
                "192.168.1.25",
                "192.168.1.15",
                "192.168.1.30",
                "192.168.1.10",
                "192.168.1.35",
                "192.168.1.20",
                "192.168.1.40",
                "192.168.1.25"
        ));

        List<String> uniqueLogs =
                deduplicatePreserveOrder(rawLogs);

        int before = rawLogs.size();
        int after = uniqueLogs.size();
        int duplicates = before - after;

        System.out.println("Початкові записи:");
        System.out.println(rawLogs);

        System.out.println("\nУнікальні записи:");
        System.out.println(uniqueLogs);

        System.out.println("\nСтатистика:");
        System.out.println("До: " + before);
        System.out.println("Після: " + after);
        System.out.println("Відкинуто дублікатів: " + duplicates);
    }
}
