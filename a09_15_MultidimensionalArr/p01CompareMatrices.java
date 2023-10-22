package a09_15_MultidimensionalArr;

import java.util.Arrays;
import java.util.Scanner;

public class p01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        if (areEqual) {

            for (int rows = 0; rows < firstMatrix.length; rows++) {

                areEqual = firstMatrix[rows].length == secondMatrix[rows].length;
                
                if(areEqual){

                    for (int i = 0; i < firstMatrix[rows].length; i++) {
                        if(firstMatrix[rows][i] != secondMatrix[rows][i]){
                            areEqual = false;
                            break;
                        }
                    }

                }

            }
        }

        if(areEqual){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
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
