package _Exam;

import java.util.Scanner;

public class e02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int r = Integer.parseInt(dimensions[0]);
        int c = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[r][c];

        for (int rows = 0; rows < r; rows++) {

            String[] inputArr = scanner.nextLine().split("\\s+");
            matrix[rows] = inputArr;
        }

        int rB = -1;
        int cB = -1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equals("B")) {
                    rB = i;
                    cB = j;
                }
            }
        }

        int touchedOpponents = 0;
        int countMoves = 0;
        String input = scanner.nextLine();

        while (touchedOpponents < 3 && !"Finish".equals(input)) {

            String direction = input;

            switch (direction) {

                case "up":

                    if (move(matrix, rB - 1, cB) == 1) {
                        countMoves++;
                        rB--;

                        if (matrix[rB][cB].equals("P")) {
                            touchedOpponents++;
                        }
                    }
                    break;

                case "down":

                    if (move(matrix, rB + 1, cB) == 1) {
                        countMoves++;
                        rB++;

                        if (matrix[rB][cB].equals("P")) {
                            touchedOpponents++;
                        }
                    }
                    break;

                case "left":

                    if (move(matrix, rB, cB - 1) == 1) {
                        countMoves++;
                        cB--;

                        if (matrix[rB][cB].equals("P")) {
                            touchedOpponents++;
                        }
                    }
                    break;

                case "right":

                    if (move(matrix, rB, cB + 1) == 1) {
                        countMoves++;
                        cB++;

                        if (matrix[rB][cB].equals("P")) {
                            touchedOpponents++;
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", touchedOpponents, countMoves);

    }

    private static int move(String[][] matrix, int r, int c) {

        if (isInRange(matrix, r, c)) {
            if (matrix[r][c].equals("O")) {
                return 0;
            } else {
                return 1;
            }
        }

        return 0;
    }

    private static boolean isInRange(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

}
