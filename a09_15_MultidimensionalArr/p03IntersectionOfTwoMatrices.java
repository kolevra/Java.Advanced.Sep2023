package a09_15_MultidimensionalArr;

import java.util.Scanner;

public class p03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = readCharMatrix(scanner, rows, cols);
        String[][] secondMatrix = readCharMatrix(scanner, rows, cols);
        char[][] finalMatrix = new char[rows][cols];

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {

                char first = firstMatrix[r][c].charAt(0);
                char second = secondMatrix[r][c].charAt(0);


                if(first == second){
                    finalMatrix[r][c] = first;
                } else {
                    finalMatrix[r][c] = '*';
                }



            }
        }


        printMatrix(finalMatrix);


    }


    private static String[][] readCharMatrix (Scanner scan, int rows, int cols){

        String[][] stringMatrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {

            stringMatrix[i] = scan.nextLine().split("\\s+");

        }

        return stringMatrix;

    }

    private static void printMatrix (char[][] matrix){

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

}
