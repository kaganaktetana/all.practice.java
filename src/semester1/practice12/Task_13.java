package semester1.practice12;

import java.util.*;

public class Task_13 {

    static class StudentRecord {
        private final String studentId;
        private String fullName;
        private double gpa;

        public StudentRecord(String studentId, String fullName, double gpa) {
            this.studentId = studentId;
            this.fullName = fullName;
            this.gpa = gpa;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getFullName() {
            return fullName;
        }

        public double getGpa() {
            return gpa;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof StudentRecord)) return false;

            StudentRecord student = (StudentRecord) o;
            return Objects.equals(studentId, student.studentId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId);
        }

        @Override
        public String toString() {
            return studentId + " | " + fullName + " | GPA: " + gpa;
        }
    }

    public static void main(String[] args) {
        Set<StudentRecord> students = new HashSet<>();

        students.add(new StudentRecord("S001", "Іван Петренко", 90.5));
        students.add(new StudentRecord("S002", "Марія Коваль", 95.0));
        students.add(new StudentRecord("S003", "Олег Бондар", 82.5));
        students.add(new StudentRecord("S004", "Анна Мельник", 88.0));

        boolean added = students.add(
                new StudentRecord("S001", "Іван Петренко", 75.0));

        System.out.println("Дублікат додано: " + added);
        System.out.println("Кількість студентів: " + students.size());

        for (StudentRecord student : students) {
            System.out.println(student);
        }
    }
}
