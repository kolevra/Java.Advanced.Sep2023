package a09_18_MultidimensionalArr_Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class p04MaximalSum {
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

        int maxSum = Integer.MIN_VALUE;
        int[][] newMatrix = new int[3][3];
        int[][] tempMatrix = new int[3][3];


        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {

                int currentSum = 0;
                int tempR = 0;

                for (int k = i; k < i + 3; k++) {

                    int tempC = 0;

                    for (int l = j; l < j + 3; l++) {
                        currentSum += matrix[k][l];

                        tempMatrix[tempR][tempC] =matrix[k][l];

                        tempC++;
                    }

                    tempR++;

                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            newMatrix[k][l] = tempMatrix[k][l];
                        }
                    }

                }


            }

        }


        System.out.println("Sum = " + maxSum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }

}
