package semester1.practice12;

import java.util.*;

public class Task_30 {

    public static void main(String[] args) {

        System.out.println("=== FILTERED ITERATOR ===");

        // Список студентів
        List<Student> students = new ArrayList<>();

        students.add(new Student("Anna", 95));
        students.add(new Student("Bohdan", 85));
        students.add(new Student("Olena", 92));
        students.add(new Student("Ivan", 78));
        students.add(new Student("Maria", 98));

        // Фільтр студентів з GPA >= 90
        FilteredIterator<Student> studentIterator =
                new FilteredIterator<>(
                        students.iterator(),
                        student -> student.getGpa() >= 90
                );

        System.out.println("\nСтуденти з GPA >= 90:");

        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }

        // Множина чисел
        Set<Integer> numbers = new LinkedHashSet<>(
                Arrays.asList(
                        7, 10, 14, 15, 21,
                        25, 28, 30, 35, 42
                )
        );

        // Фільтр чисел, кратних 7
        FilteredIterator<Integer> numberIterator =
                new FilteredIterator<>(
                        numbers.iterator(),
                        number -> number % 7 == 0
                );

        System.out.println("\nЧисла, кратні 7:");

        while (numberIterator.hasNext()) {
            System.out.print(numberIterator.next() + " ");
        }

        System.out.println();
    }

    // Функціональний інтерфейс фільтра
    public interface ElementFilter<T> {

        boolean accept(T element);
    }

    // Фільтруючий ітератор
    public static class FilteredIterator<T>
            implements Iterator<T> {

        private final Iterator<T> iterator;
        private final ElementFilter<T> filter;

        private T nextElement;
        private boolean hasNextElement = false;

        public FilteredIterator(
                Iterator<T> iterator,
                ElementFilter<T> filter) {

            this.iterator = iterator;
            this.filter = filter;
        }

        // Пошук наступного елемента,
        // який відповідає умові фільтра
        private void advance() {

            if (hasNextElement) {
                return;
            }

            while (iterator.hasNext()) {

                T element = iterator.next();

                if (filter.accept(element)) {

                    nextElement = element;

                    hasNextElement = true;

                    return;
                }
            }
        }

        @Override
        public boolean hasNext() {

            advance();

            return hasNextElement;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T result = nextElement;

            nextElement = null;

            hasNextElement = false;

            return result;
        }

        // Видалення через цей декоратор не підтримується
        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "Remove is not supported"
            );
        }
    }

    // Клас студента
    public static class Student {

        private final String name;
        private final double gpa;

        public Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return name + " | GPA: " + gpa;
        }
    }
}
