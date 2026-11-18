package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task1WrapperAndAutoboxingMemoryHW {

    public static void inspectIntegerCache(int[] testValues) {

        System.out.println("[1. ЕКСПЕРИМЕНТ: INTEGER CACHE]");

        for (int val : testValues) {

            Integer first = Integer.valueOf(val);
            Integer second = Integer.valueOf(val);

            boolean sameReference = first == second;
            boolean sameValue = first.equals(second);

            String source = (val >= -128 && val <= 127)
                    ? "IntegerCache"
                    : "Новий об'єкт у Heap";

            System.out.printf(
                    "Значення: %5d | (a == b): %-5b | a.equals(b): %-5b | Джерело: %s%n",
                    val, sameReference, sameValue, source
            );
        }
    }

    public static void demonstrateAutoboxingUnderTheHood() {

        System.out.println("\n[2. AUTOBOXING / UNBOXING ПІД КАПОТОМ]");

        // Integer
        int primitiveInt = 42;

        Integer automaticInteger = primitiveInt;
        Integer explicitInteger = Integer.valueOf(primitiveInt);

        int automaticUnboxing = automaticInteger;
        int explicitUnboxing = explicitInteger.intValue();

        System.out.println(
                "Integer: valueOf(42) -> " + explicitInteger
                        + " | intValue() -> " + explicitUnboxing
        );

        // Double
        double primitiveDouble = 15.5;

        Double automaticDouble = primitiveDouble;
        Double explicitDouble = Double.valueOf(primitiveDouble);

        double automaticDoubleUnboxing = automaticDouble;
        double explicitDoubleUnboxing = explicitDouble.doubleValue();

        System.out.println(
                "Double: valueOf(15.5) -> " + explicitDouble
                        + " | doubleValue() -> " + explicitDoubleUnboxing
        );

        // Boolean
        boolean primitiveBoolean = true;

        Boolean automaticBoolean = primitiveBoolean;
        Boolean explicitBoolean = Boolean.valueOf(primitiveBoolean);

        boolean automaticBooleanUnboxing = automaticBoolean;
        boolean explicitBooleanUnboxing = explicitBoolean.booleanValue();

        System.out.println(
                "Boolean: valueOf(true) -> " + explicitBoolean
                        + " | booleanValue() -> " + explicitBooleanUnboxing
        );

        // Захист від NullPointerException
        List<Integer> sensors = new ArrayList<>(
                java.util.Arrays.asList(45, null, -12, 88, null, 102)
        );

        System.out.println("\nСписок датчиків: " + sensors);

        int sum = 0;

        for (int i = 0; i < sensors.size(); i++) {

            Integer value = sensors.get(i);

            if (value == null) {
                System.out.println(
                        "Пропущено null-елемент на індексі " + i
                );
            } else {
                int number = value.intValue();
                sum += number;
            }
        }

        System.out.println("Сума валідних елементів: " + sum);
    }

    public static List<Integer> parseTelemetryStream(String[] rawPackets) {

        List<Integer> validData = new ArrayList<>();

        for (String packet : rawPackets) {

            if (packet == null || packet.trim().isEmpty()) {
                System.out.println("Порожній або null-пакет відхилено");
                continue;
            }

            try {

                int number = Integer.parseInt(packet.trim());
                validData.add(number);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Пакет '" + packet + "' відхилено (NumberFormatException)"
                );
            }
        }

        return validData;
    }

    public static void printExtremesAndStats(List<Integer> validData) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        System.out.println("\nПочаткові межі:");
        System.out.println("min = " + min);
        System.out.println("max = " + max);

        for (Integer value : validData) {

            int number = value.intValue();

            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }

            sum += number;
        }

        System.out.println("Валідні дані: " + validData);

        if (!validData.isEmpty()) {
            System.out.println("Мінімум: " + min);
            System.out.println("Максимум: " + max);
            System.out.println("Сума: " + sum);
        } else {
            System.out.println("Немає валідних даних");
        }

        // Демонстрація різниці remove за індексом і за значенням
        List<Integer> indexCopy = new ArrayList<>(validData);
        List<Integer> valueCopy = new ArrayList<>(validData);

        if (!indexCopy.isEmpty()) {

            Integer firstValue = indexCopy.get(0);

            indexCopy.remove(0);

            System.out.println(
                    "Після remove(0) за індексом: " + indexCopy
            );

            valueCopy.remove(Integer.valueOf(-30));

            System.out.println(
                    "Після remove(Integer.valueOf(-30)) за значенням: "
                            + valueCopy
            );
        }
    }

    public static void main(String[] args) {

        System.out.println(
                "================ ДОСЛІДЖЕННЯ WRAPPER CLASSES ТА INTEGER CACHE ================"
        );

        int[] testValues = {
                -128, -50, 0, 127, 128, 500, 2026
        };

        inspectIntegerCache(testValues);

        demonstrateAutoboxingUnderTheHood();

        System.out.println(
                "\n[3. ПАРСИНГ РЯДКІВ ТА ПОШУК ЕКСТРЕМУМІВ]"
        );

        String[] rawPackets = {
                "  145 ",
                "-30",
                "ERR_404",
                "980",
                "",
                null,
                "2147483647",
                "-85"
        };

        List<Integer> validData = parseTelemetryStream(rawPackets);

        printExtremesAndStats(validData);

        System.out.println(
                "============================================================================="
        );
    }
}
