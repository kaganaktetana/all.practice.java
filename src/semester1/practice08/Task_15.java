package semester1.practice08;

public class Task_15 {
    public static void main(String[] args) {
        PrintedBook book = new PrintedBook(
                "1984",
                "Джордж Орвелл",
                1949,
                328,
                "Тверда"
        );

        AudioBook audioBook = new AudioBook(
                "Квіти для Елджернона",
                "Деніел Кіз",
                1966,
                540,
                "Андрій Самінін"
        );

        System.out.println(book);
        System.out.println();
        System.out.println(audioBook);
    }
}

class Publication {
    private String title;
    private String author;
    private int releaseYear;

    public Publication(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Назва: " + title
                + ", автор: " + author
                + ", рік видання: " + releaseYear;
    }
}

class PrintedBook extends Publication {
    private int pageCount;
    private String coverType;

    public PrintedBook(String title, String author, int releaseYear,
                       int pageCount, String coverType) {
        super(title, author, releaseYear);

        this.pageCount = pageCount;
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Друкована книга: " + super.toString()
                + ", кількість сторінок: " + pageCount
                + ", обкладинка: " + coverType;
    }
}

class AudioBook extends Publication {
    private int durationMinutes;
    private String narrator;

    public AudioBook(String title, String author, int releaseYear,
                     int durationMinutes, String narrator) {
        super(title, author, releaseYear);

        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }

    public String formatDuration() {
        int hours = durationMinutes / 60;
        int minutes = durationMinutes % 60;

        return hours + " год " + minutes + " хв";
    }

    @Override
    public String toString() {
        return "Аудіокнига: " + super.toString()
                + ", тривалість: " + formatDuration()
                + ", диктор: " + narrator;
    }
}