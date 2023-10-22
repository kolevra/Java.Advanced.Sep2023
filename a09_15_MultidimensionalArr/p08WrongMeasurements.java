package a09_15_MultidimensionalArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] inputArr = scanner.nextLine().split("\\s+");
        int x = Integer.parseInt(inputArr[0]);
        int y = Integer.parseInt(inputArr[1]);

        int wrongNumber = matrix[x][y];
        List<int[]> correctValues = new ArrayList<>();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                int newValue = 0;

                if (matrix[i][j] == wrongNumber) {

                    if (isInRange(matrix, i - 1, j) && matrix[i - 1][j] != wrongNumber) {
                        newValue += matrix[i - 1][j];
                    }

                    if (isInRange(matrix, i + 1, j) && matrix[i + 1][j] != wrongNumber) {
                        newValue += matrix[i + 1][j];
                    }

                    if (isInRange(matrix, i, j - 1) && matrix[i][j - 1] != wrongNumber) {
                        newValue += matrix[i][j - 1];
                    }

                    if (isInRange(matrix, i, j + 1) && matrix[i][j + 1] != wrongNumber) {
                        newValue += matrix[i][j + 1];
                    }


                    int[] toSaveArr = new int[3];
                    toSaveArr[0] = newValue;
                    toSaveArr[1] = i;
                    toSaveArr[2] = j;

                    correctValues.add(toSaveArr);

                }

            }

        }

        for (int[] entry : correctValues) {
            matrix[entry[1]][entry[2]] = entry[0];
        }


        printMatrix(matrix);


    }

    public static boolean isInRange(int[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }

    public static void printMatrix (int[][] matrix){

        for (int[] arr : matrix) {

            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();

        }

    }

}
