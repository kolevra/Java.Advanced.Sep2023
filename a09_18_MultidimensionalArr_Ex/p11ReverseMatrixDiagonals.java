package a09_18_MultidimensionalArr_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class p11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(inputArr[0]);
        int cols = Integer.parseInt(inputArr[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        int rStart = matrix.length - 1;
        int cStart = matrix[matrix.length - 1].length - 1;

        boolean isPrint = true;

        while (isPrint) {

            isPrint = false;


            for (int i = 0; i < matrix.length; i++) {

                if (isInRange(matrix, rStart - i, cStart + i)) {

                    System.out.print(matrix[rStart - i][cStart + i] + " ");
                    isPrint = true;

                }

            }

            if(isPrint){
                System.out.println();
            }
            cStart--;

        }

    }

    public static boolean isInRange(int[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }

}
