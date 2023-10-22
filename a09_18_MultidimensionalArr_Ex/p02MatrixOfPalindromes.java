package a09_18_MultidimensionalArr_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class p02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[inputArr[0]][inputArr[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = String.valueOf((char) ('a' + i)) +
                        String.valueOf((char) ('a' + j + i)) +
                        String.valueOf((char) ('a' + i));

//                char outsideSymbol = (char) ('a' + row);
//                char midSymbol = (char) (outsideSymbol + col);
//                matrix[row][col] = String.valueOf(new char[] {outsideSymbol, midSymbol, outsideSymbol});


            }

        }

        printMatrix(matrix);

    }

    public  static  void printMatrix (String[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
