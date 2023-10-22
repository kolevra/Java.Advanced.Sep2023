package a09_15_MultidimensionalArr;

import java.util.Arrays;
import java.util.Scanner;

public class p05MaximumSumOfTwoByTwoSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(", ");

        int row = Integer.parseInt(inputArr[0]);
        int col = Integer.parseInt(inputArr[1]);

        int[][] matrix = new int[row][col];
        int[][] topMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;


        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {

                int topLeft = matrix[i][j];
                int topRight = matrix[i][j + 1];
                int bottomRight = matrix[i + 1][j + 1];
                int bottomLeft = matrix[i + 1][j];

                int currentSum = topLeft + topRight + bottomLeft + bottomRight;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    topMatrix[0][0] = topLeft;
                    topMatrix[0][1] = topRight;
                    topMatrix[1][0] = bottomLeft;
                    topMatrix[1][1] = bottomRight;

                }

            }

        }


        System.out.println(topMatrix[0][0] + " " + topMatrix[0][1]);
        System.out.println(topMatrix[1][0] + " " + topMatrix[1][1]);
        System.out.println(maxSum);


    }
}
