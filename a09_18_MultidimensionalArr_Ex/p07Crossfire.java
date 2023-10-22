package a09_18_MultidimensionalArr_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int sizeX = Integer.parseInt(dimensions[0]);
        int sizeY = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, sizeX, sizeY);

        String input = scanner.nextLine();

        while (!"Nuke it from orbit".equals(input)) {

            String[] attackArr = input.split("\\s+");
            int rowTarget = Integer.parseInt(attackArr[0]);
            int colTarget = Integer.parseInt(attackArr[1]);
            int radius = Integer.parseInt(attackArr[2]);

                for (int r = rowTarget - radius; r <= rowTarget + radius; r++) {

                    if (isInRange(matrix, r, colTarget)) {

                        matrix.get(r).set(colTarget, 0);
                    }
                }

                for (int c = colTarget - radius; c <= colTarget + radius; c++) {

                    if (isInRange(matrix, rowTarget, c)) {

                        matrix.get(rowTarget).set(c, 0);
                    }
                }

                for (int row = 0; row < matrix.size(); row++) {

                    List<Integer> currentRow = matrix.get(row);
                    currentRow.removeAll(List.of(0));

                    if(matrix.get(row).size() == 0){
                        matrix.remove(row);
                        row--;
                    }
                }

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static boolean isInRange(List<List<Integer>> matrix, int r, int c) {
        return r >= 0 && r < matrix.size() && c >= 0 && c < matrix.get(r).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int r, int c) {

        int number = 1;
        for (int i = 0; i < r; i++) {

            List<Integer> rows = new ArrayList<>();

            for (int j = 0; j < c; j++) {

                rows.add(number);
                number++;
            }
            matrix.add(rows);
        }
    }

}
