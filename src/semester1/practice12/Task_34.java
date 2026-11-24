
package semester1.practice12;

import java.util.*;

public class Task_34 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 0, 4, 5},
                {3, 0, 7, 8, 9},
                {5, 6, 0, 2, 1},
                {4, 2, 0, 5, 7}
        };

        // Унікальні елементи
        TreeSet<Integer> unique = new TreeSet<>();

        for (int[] row : matrix) {
            for (int value : row) {
                unique.add(value);
            }
        }

        System.out.println("=== УНІКАЛЬНІ ЕЛЕМЕНТИ ===");
        System.out.println(unique);

        // Перетин першого та останнього рядків
        Set<Integer> firstRow = new HashSet<>();
        Set<Integer> lastRow = new HashSet<>();

        for (int value : matrix[0]) {
            firstRow.add(value);
        }

        for (int value : matrix[matrix.length - 1]) {
            lastRow.add(value);
        }

        firstRow.retainAll(lastRow);

        System.out.println("\nПеретин першого та останнього рядків:");
        System.out.println(firstRow);

        // Пошук координат нулів
        List<String> coordinates = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {

                if (matrix[r][c] == 0) {
                    coordinates.add(r + "," + c);
                }
            }
        }

        // Форматування через ListIterator
        ListIterator<String> it = coordinates.listIterator();

        while (it.hasNext()) {

            String coordinate = it.next();
            String[] parts = coordinate.split(",");

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            it.set("[row=" + row + ", col=" + col + "]");
        }

        System.out.println("\nКоординати нульових елементів:");
        System.out.println(coordinates);
    }
}
