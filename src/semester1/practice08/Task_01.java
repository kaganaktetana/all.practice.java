
package semester1.practice08;

public class Task_01 {

    public static void main(String[] args) {

        Student student = new Student("Тетяна", 1, 95.5);

        System.out.println(student);

        // Перевірка валідації
        student.setCourse(8);
        student.setGpa(120);

        System.out.println("Після некоректних змін:");
        System.out.println(student);
    }
}

class Student {

    private String name;
    private int course;
    private double gpa;

    public Student(String name, int course, double gpa) {
        this.name = name;
        setCourse(course);
        setGpa(gpa);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= 6) {
            this.course = course;
        } else {
            this.course = 1;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 100.0) {
            this.gpa = gpa;
        } else {
            this.gpa = 60.0;
        }
    }

    @Override
    public String toString() {
        return "Student{name='" + name +
                "', course=" + course +
                ", gpa=" + gpa + "}";
    }
}


