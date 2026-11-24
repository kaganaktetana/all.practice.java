
package semester1.practice12;

import java.util.*;

public class Task_31 {

    static final class Book {
        private final String isbn;
        private final String title;
        private final int year;

        public Book(String isbn, String title, int year) {
            this.isbn = isbn;
            this.title = title;
            this.year = year;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book book)) return false;
            return Objects.equals(isbn, book.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isbn);
        }

        @Override
        public String toString() {
            return title + " (" + year + "), ISBN: " + isbn;
        }
    }

    public static void main(String[] args) {

        Set<Book> books = new HashSet<>();

        books.add(new Book("111", "Java Basics", 2018));
        books.add(new Book("222", "Effective Java", 2020));
        books.add(new Book("333", "Clean Code", 2008));
        books.add(new Book("444", "Spring Boot", 2022));
        books.add(new Book("555", "Algorithms", 2012));

        // Дублікат ISBN
        books.add(new Book("111", "Java Basics New Edition", 2024));

        System.out.println("=== HASHSET: Унікальні книги ===");
        for (Book book : books) {
            System.out.println(book);
        }

        // Сортування: рік за спаданням, потім назва
        TreeSet<Book> sortedBooks = new TreeSet<>(
                Comparator.comparingInt(Book::getYear)
                        .reversed()
                        .thenComparing(Book::getTitle)
        );

        sortedBooks.addAll(books);

        System.out.println("\n=== TREЕSET: Сортування книг ===");

        Iterator<Book> it = sortedBooks.iterator();

        while (it.hasNext()) {
            Book book = it.next();

            if (book.getYear() < 2015) {
                it.remove();
            }
        }

        for (Book book : sortedBooks) {
            System.out.println(book);
        }

        System.out.println("\nКількість актуальних книг: "
                + sortedBooks.size());
    }
}
