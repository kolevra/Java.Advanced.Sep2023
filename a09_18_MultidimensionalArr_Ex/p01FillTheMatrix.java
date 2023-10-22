package a09_18_MultidimensionalArr_Ex;

import java.util.Scanner;

public class p01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputArr = scanner.nextLine().split(", ");
        int size = Integer.parseInt(inputArr[0]);
        String pattern = inputArr[1];


        int[][] matrix = new int[size][size];

        if("A".equals(pattern)){
            fillPatternA(matrix);
        } else {
            fillPatternB(matrix);
        }

        printMatrix(matrix);

    }

    public static void fillPatternA (int[][] matrix){

        int startNumber = 1;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                matrix[j][i] = startNumber;
                startNumber++;
            }

        }

    }


    public static void fillPatternB (int[][] matrix){

        int startNumber = 1;

        for (int i = 0; i < matrix.length; i++) {

            if(i % 2 == 0){

                for (int j = 0; j < matrix[i].length; j++) {

                    matrix[j][i] = startNumber;
                    startNumber++;
                }

            } else {

                for (int j = matrix[i].length - 1; j >=0; j--) {

                    matrix[j][i] = startNumber;
                    startNumber++;
                }

            }


        }

    }

    public  static  void printMatrix (int[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
