
package semester1.practice11;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_23 {

    public static ArrayList<String> findIntersection(
            ArrayList<String> listA,
            ArrayList<String> listB) {

        ArrayList<String> result = new ArrayList<>();

        for (String student : listA) {

            if (listB.contains(student) && !result.contains(student)) {
                result.add(student);
            }
        }

        return result;
    }

    public static ArrayList<String> findDifference(
            ArrayList<String> listA,
            ArrayList<String> listB) {

        ArrayList<String> result = new ArrayList<>(listA);

        result.removeAll(listB);

        return result;
    }

    public static void main(String[] args) {

        ArrayList<String> listA = new ArrayList<>(
                Arrays.asList("Анна", "Богдан", "Олена", "Іван", "Марія")
        );

        ArrayList<String> listB = new ArrayList<>(
                Arrays.asList("Олена", "Іван", "Марія", "Петро")
        );

        System.out.println("Склали Java: " + listA);
        System.out.println("Склали бази даних: " + listB);

        System.out.println("Склали обидва іспити: "
                + findIntersection(listA, listB));

        System.out.println("Склали лише Java: "
                + findDifference(listA, listB));
    }
}
