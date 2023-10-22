package a09_15_MultidimensionalArr;

import java.util.Arrays;
import java.util.Scanner;

public class p06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        for (int i = 0; i < size; i++) {
                System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int i = size - 1; i >= 0; i--) {
            System.out.print(matrix[i][size - 1 - i] + " ");
        }
    }
}
