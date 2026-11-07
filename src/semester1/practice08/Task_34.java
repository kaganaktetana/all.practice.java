package semester1.practice08;

import java.util.Arrays;

public class Task_34 {
    public static void main(String[] args) {

        int[] grades = {90, 80, 100, 70};

        double[] weights = {1.0, 2.0, 3.0, 1.0};

        GradeSheet regular = new GradeSheet(
                "Олена",
                grades
        );

        WeightedGradeSheet weighted = new WeightedGradeSheet(
                "Олена",
                grades,
                weights
        );

        System.out.println(regular);

        System.out.println();

        System.out.println(weighted);
    }
}

class GradeSheet {
    private String studentName;
    protected int[] grades;

    public GradeSheet(String studentName, int[] grades) {
        this.studentName = studentName;

        this.grades = Arrays.copyOf(grades, grades.length);
    }

    public double calculateScore() {
        if (grades.length == 0) {
            return 0;
        }

        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.length;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Залікова відомість"
                + "\nСтудент: " + studentName
                + "\nОцінки: " + Arrays.toString(grades)
                + "\nЗвичайний середній бал: "
                + calculateScore();
    }
}

class WeightedGradeSheet extends GradeSheet {
    private double[] weights;

    public WeightedGradeSheet(String studentName,
                              int[] grades,
                              double[] weights) {
        super(studentName, grades);

        if (weights.length != grades.length) {
            throw new IllegalArgumentException(
                    "Кількість ваг повинна дорівнювати кількості оцінок"
            );
        }

        this.weights = Arrays.copyOf(weights, weights.length);
    }

    @Override
    public double calculateScore() {
        if (grades.length == 0) {
            return 0;
        }

        double weightedSum = 0;
        double totalWeight = 0;

        for (int i = 0; i < grades.length; i++) {
            weightedSum += grades[i] * weights[i];
            totalWeight += weights[i];
        }

        if (totalWeight == 0) {
            return 0;
        }

        return weightedSum / totalWeight;
    }

    @Override
    public String toString() {
        return "Зважена залікова відомість"
                + "\nСтудент: " + getStudentName()
                + "\nОцінки: " + Arrays.toString(grades)
                + "\nВаги: " + Arrays.toString(weights)
                + "\nЗважений середній бал: "
                + calculateScore();
    }
}