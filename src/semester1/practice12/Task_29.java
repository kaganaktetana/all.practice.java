package semester1.practice12;

import java.util.*;

public class Task_29 {

    public static void main(String[] args) {

        PrimeNumberGenerator generator =
                new PrimeNumberGenerator(100);

        Set<Integer> primes = new HashSet<>();

        System.out.println("=== PRIME NUMBERS ===");

        // Виведення простих чисел через for-each
        for (int p : generator) {

            System.out.print(p + " ");

            primes.add(p);
        }

        System.out.println("\n\nКількість простих чисел: "
                + primes.size());

        // Перевірка гіпотези Гольдбаха для 84
        int number = 84;

        System.out.println("\n=== GOLD BACH HYPOTHESIS ===");

        boolean found = false;

        for (int p1 : primes) {

            int p2 = number - p1;

            if (primes.contains(p2) && p1 <= p2) {

                System.out.println(
                        number + " = " + p1 + " + " + p2
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "Пару простих чисел не знайдено."
            );
        } else {
            System.out.println(
                    "Гіпотеза перевірена: пара знайдена!"
            );
        }
    }

    // Генератор простих чисел
    public static class PrimeNumberGenerator
            implements Iterable<Integer> {

        private final int maxLimit;

        public PrimeNumberGenerator(int maxLimit) {
            this.maxLimit = maxLimit;
        }

        // Перевірка простого числа
        private boolean isPrime(int number) {

            if (number < 2) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(number); i++) {

                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public Iterator<Integer> iterator() {

            return new Iterator<Integer>() {

                private int current = 1;

                private Integer nextPrime = null;

                // Пошук наступного простого числа
                private void findNext() {

                    if (nextPrime != null) {
                        return;
                    }

                    while (current < maxLimit) {

                        current++;

                        if (isPrime(current)) {
                            nextPrime = current;
                            return;
                        }
                    }
                }

                @Override
                public boolean hasNext() {

                    findNext();

                    return nextPrime != null;
                }

                @Override
                public Integer next() {

                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }

                    int result = nextPrime;

                    nextPrime = null;

                    return result;
                }
            };
        }
    }
}
