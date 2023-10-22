package a09_15_MultidimensionalArr;

import java.util.Arrays;
import java.util.Scanner;

public class p02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int numberToCheck = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if(matrix[row][col] == numberToCheck){

                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if(!isFound){
            System.out.println("not found");
        }


    }

    private static int[] readIntArr(Scanner scan) {

        return Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static int[][] readMatrix(Scanner scan) {

        int[] matrixSize = readIntArr(scan);

        int row = matrixSize[0];
        int col = matrixSize[1];

        int[][] matrix = new int[row][col];

        for (int r = 0; r < matrix.length; r++) {
            int[] rowArr = readIntArr(scan);
            matrix[r] = rowArr;
        }

        return matrix;

    }

}
