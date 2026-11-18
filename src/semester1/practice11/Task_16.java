
package semester1.practice11;

import java.util.ArrayList;
import java.util.List;

public class Task_16 {

    public static ArrayList<Integer> extractPassedScores(
            List<Integer> allScores, int minPassScore) {

        ArrayList<Integer> passedScores = new ArrayList<>();

        for (int i = 0; i < allScores.size(); i++) {

            if (allScores.get(i) >= minPassScore) {
                passedScores.add(allScores.get(i));
            }
        }

        return passedScores;
    }

    public static void main(String[] args) {

        ArrayList<Integer> scores = new ArrayList<>(
                List.of(45, 88, 92, 59, 74, 100, 38, 65)
        );

        ArrayList<Integer> passed = extractPassedScores(scores, 60);

        int failedCount = scores.size() - passed.size();

        System.out.println("Початковий список: " + scores);
        System.out.println("Початковий size: " + scores.size());
        System.out.println("Кількість зарахованих: " + passed.size());
        System.out.println("Кількість незарахованих: " + failedCount);
        System.out.println("Зараховані бали: " + passed);
    }
}
