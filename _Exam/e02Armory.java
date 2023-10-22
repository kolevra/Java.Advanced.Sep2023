package _Exam;

import java.util.Scanner;

public class e02Armory {
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

                if (matrix[i][j].equals("A")) {
                    row = i;
                    col = j;
                    break;
                }

            }
        }

        int boughtBladesFor = 0;
        boolean isOutside = false;

        while (boughtBladesFor < 65) {

            matrix[row][col] = "-";

            String input = scanner.nextLine();

            switch (input) {

                case "up":
                    row--;
                    break;

                case "down":
                    row++;
                    break;

                case "left":
                    col--;
                    break;

                case "right":
                    col++;
                    break;

            }

            if (isInRange(size, row, col)) {

                if (matrix[row][col].equals("M")) {
                    matrix[row][col] = "-";

                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {

                            if (matrix[i][j].equals("M")) {
                                row = i;
                                col = j;
                                break;
                            }

                        }
                    }

                } else if (isNumeric(matrix[row][col])) {

                    boughtBladesFor += Integer.parseInt(matrix[row][col]);

                }

                matrix[row][col] = "A";

            } else {
                isOutside = true;
                break;
            }

        }


        if(isOutside){
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", boughtBladesFor);

        printMatrix(matrix);


    }

    private static boolean isInRange(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder CurrentRow = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                CurrentRow.append(matrix[r][c]);
            }
            System.out.println(CurrentRow.toString());
        }
    }

}
