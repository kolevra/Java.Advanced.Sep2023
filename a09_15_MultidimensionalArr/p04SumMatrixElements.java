package a09_15_MultidimensionalArr;

import java.util.Scanner;

public class p04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(", ");

        int row = Integer.parseInt(inputArr[0]);
        int col = Integer.parseInt(inputArr[1]);

        String[][] matrix = new String[row][col];

        int sum = 0;

        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(", ");

            for (int j = 0; j < col; j++) {
                int currentValue = Integer.parseInt(matrix[i][j]);
                sum += currentValue;
            }

        }

        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);

    }
}
