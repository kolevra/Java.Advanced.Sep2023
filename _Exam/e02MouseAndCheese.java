package _Exam;

import java.util.Scanner;

public class e02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("M")) {
                    row = i;
                    col = j;
                }
            }
        }

        String input = scanner.nextLine();
        int cheeseEaten = 0;

        while (!"end".equals(input)) {

            boolean isBonusFound = false;

            int oldR = row;
            int oldC = col;

            switch (input) {

                case "left":
                    col--;
                    break;

                case "right":
                    col++;
                    break;

                case "up":
                    row--;
                    break;

                case "down":
                    row++;
                    break;
            }

            matrix[oldR][oldC] = "-";

            if (!isInRange(size, row, col)) {
                System.out.println("Where is the mouse?");
                break;
            } else {

                if (matrix[row][col].equals("c")) {
                    cheeseEaten++;
                    matrix[row][col] = "-";

                } else if (matrix[row][col].equals("B")) {
                    matrix[row][col] = "-";
                    isBonusFound = true;
                }

                matrix[row][col] = "M";
            }

            if (!isBonusFound) {
                input = scanner.nextLine();
            }
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", (5 - cheeseEaten));
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printMatrix(matrix);

    }

    public static boolean isInRange(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }


    public static void printMatrix(String[][] matrixToPrint) {

        for (int i = 0; i < matrixToPrint.length; i++) {
            for (int j = 0; j < matrixToPrint[i].length; j++) {
                System.out.print(matrixToPrint[i][j]);
            }
            System.out.println();
        }
    }

}
