package semester1.practice08;

public class Task_31 {
    public static void main(String[] args) {

        PostgraduateStudent student = new PostgraduateStudent(
                101,
                "student@gmail.com",
                "KN-21",
                90.5,
                "Штучний інтелект у медицині",
                "Іван Петренко"
        );

        System.out.println(student);

        System.out.println("\nДопуск до захисту: "
                + (student.canDefendThesis() ? "ДОПУЩЕНО" : "НЕ ДОПУЩЕНО"));
    }
}

class User {
    private int id;
    private String email;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", email: " + email;
    }
}

class StudentUser extends User {
    private String groupCode;
    private double gpa;

    public StudentUser(int id, String email,
                       String groupCode, double gpa) {
        super(id, email);

        this.groupCode = groupCode;
        this.gpa = gpa;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", група: " + groupCode
                + ", GPA: " + gpa;
    }
}

class PostgraduateStudent extends StudentUser {
    private String thesisTopic;
    private String supervisorName;

    public PostgraduateStudent(int id, String email,
                               String groupCode, double gpa,
                               String thesisTopic,
                               String supervisorName) {
        super(id, email, groupCode, gpa);

        this.thesisTopic = thesisTopic;
        this.supervisorName = supervisorName;
    }

    public boolean canDefendThesis() {
        return getGpa() >= 85.0
                && thesisTopic != null
                && !thesisTopic.trim().isEmpty();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nТема дисертації: " + thesisTopic
                + "\nНауковий керівник: " + supervisorName
                + "\nДопуск до захисту: "
                + (canDefendThesis() ? "так" : "ні");
    }
}