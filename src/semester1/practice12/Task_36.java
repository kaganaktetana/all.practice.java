
package semester1.practice12;

import java.util.*;

public class Task_36 {

    static final class Interval implements Comparable<Interval> {
        private final double start;
        private final double end;

        public Interval(double start, double end) {
            if (start > end) {
                throw new IllegalArgumentException(
                        "Початок не може бути більшим за кінець!");
            }

            this.start = start;
            this.end = end;
        }

        public double getStart() {
            return start;
        }

        public double getEnd() {
            return end;
        }

        public double length() {
            return end - start;
        }

        @Override
        public int compareTo(Interval other) {
            int result = Double.compare(start, other.start);

            if (result == 0) {
                return Double.compare(end, other.end);
            }

            return result;
        }

        @Override
        public String toString() {
            return "[" + start + "; " + end + "]";
        }
    }

    public static List<Interval> mergeIntervals(
            TreeSet<Interval> intervals) {

        List<Interval> result = new ArrayList<>();

        Iterator<Interval> it = intervals.iterator();

        if (!it.hasNext()) {
            return result;
        }

        Interval current = it.next();

        while (it.hasNext()) {
            Interval next = it.next();

            if (next.getStart() <= current.getEnd()) {

                current = new Interval(
                        current.getStart(),
                        Math.max(current.getEnd(), next.getEnd())
                );

            } else {

                result.add(current);
                current = next;
            }
        }

        result.add(current);

        return result;
    }

    public static void main(String[] args) {

        TreeSet<Interval> intervals = new TreeSet<>();

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(9, 12));
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(14, 16));
        intervals.add(new Interval(15, 20));

        System.out.println("=== ПОЧАТКОВІ ІНТЕРВАЛИ ===");

        for (Interval interval : intervals) {
            System.out.println(interval);
        }

        List<Interval> merged = mergeIntervals(intervals);

        System.out.println("\n=== ОБ'ЄДНАНІ ІНТЕРВАЛИ ===");

        double totalLength = 0;

        for (Interval interval : merged) {
            System.out.println(interval);
            totalLength += interval.length();
        }

        System.out.println("\nКількість інтервалів: " + merged.size());

        System.out.println("Сумарна довжина: "
                + totalLength);
    }
}
