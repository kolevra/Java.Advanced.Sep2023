package a09_18_MultidimensionalArr_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class p03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {

            int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = inputArr;

        }

        int diagonalOne = 0;
        int diagonalTow = 0;

        for (int i = 0; i < matrix.length; i++) {

                diagonalOne += matrix[i][i];

        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            diagonalTow += matrix[i][matrix.length - 1 - i];
        }


        int result = Math.abs(diagonalOne - diagonalTow);
        System.out.println(result);


    }
}
