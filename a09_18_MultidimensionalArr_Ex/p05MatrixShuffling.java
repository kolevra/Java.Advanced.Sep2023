package a09_18_MultidimensionalArr_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class p05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(inputArr[0]);
        int col = Integer.parseInt(inputArr[1]);

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();

        while(!"END".equals(input)){

            String[] tokenArr = input.split("\\s+");
            String command = tokenArr[0];

            if("swap".equals(command) && tokenArr.length == 5){

                int x1 = Integer.parseInt(tokenArr[1]);
                int y1 = Integer.parseInt(tokenArr[2]);
                int x2 = Integer.parseInt(tokenArr[3]);
                int y2 = Integer.parseInt(tokenArr[4]);

                if(isInRange(matrix, x1, y1) && isInRange(matrix, x2, y2)){

                    String tempValue = matrix[x1][y1];
                    matrix[x1][y1] =  matrix[x2][y2];
                    matrix[x2][y2] = tempValue;

                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    public static boolean isInRange(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }

    public static void printMatrix (String[][] matrixToPrint){

        for (int i = 0; i < matrixToPrint.length; i++) {
            for (int j = 0; j < matrixToPrint[i].length; j++) {
                System.out.print(matrixToPrint[i][j] + " ");
            }
            System.out.println();
        }

    }

}
