package _Exam;

import java.util.Scanner;

public class e02DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsArr = scanner.nextLine().split("\\s+");

        int rowsMatrix = Integer.parseInt(dimensionsArr[0]);
        int colsMatrix = Integer.parseInt(dimensionsArr[1]);

        String[][] matrix = new String[rowsMatrix][colsMatrix];

        for (int i = 0; i < rowsMatrix; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int startR = -1;
        int startC = -1;

        for (int row = 0; row < rowsMatrix; row++) {
            for (int col = 0; col < colsMatrix; col++) {
                if (matrix[row][col].equals("B")) {
                    startR = row;
                    startC = col;
                    break;
                }
            }
        }


        boolean isOutside = false;
        boolean isDelivered = false;
        boolean isPizzaReceived = false;
        int currentR = startR;
        int currentC = startC;

        matrix[currentR][currentC] = "-";

        while (!isDelivered && !isOutside) {
            String input = scanner.nextLine();

            int prevR = currentR;
            int prevC = currentC;

            switch (input) {

                case "up":
                    currentR--;
                    break;
                case "down":
                    currentR++;
                    break;
                case "right":
                    currentC++;
                    break;
                case "left":
                    currentC--;
                    break;
            }

            if (isInRange(matrix, currentR, currentC)) {

                if (matrix[currentR][currentC].equals("-")) {
                    matrix[currentR][currentC] = ".";
                } else if (matrix[currentR][currentC].equals("P")) {
                    matrix[currentR][currentC] = "R";
                    System.out.println("Pizza is collected. 10 minutes for delivery.");
                    isPizzaReceived = true;
                } else if (isPizzaReceived && matrix[currentR][currentC].equals("A")) {
                    matrix[currentR][currentC] = "P";
                    System.out.println("Pizza is delivered on time! Next order...");
                    isDelivered = true;
                    break;
                } else if(matrix[currentR][currentC].equals("*")) {
                    currentR = prevR;
                    currentC = prevC;
                }

            } else {
                System.out.println("The delivery is late. Order is canceled.");
                isOutside = true;
                break;
            }

        }

        if (isOutside) {
            matrix[startR][startC] = " ";
        } else {
            matrix[startR][startC] = "B";
        }

        printMatrix(matrix);

    }

    private static boolean isInRange(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

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
