package a09_15_MultidimensionalArr;

import java.util.Scanner;

public class p07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (matrix[i][j] == 'q') {

                    if (isAloneInRow(matrix, i)) {

                        if (isAloneInCol(matrix, j)) {

                            if (isAloneInFirstDiagonal(matrix, i, j)) {

                                if (isAloneInSecondDiagonal(matrix, i, j)) {

                                    System.out.println(i + " " + j);

                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

    private static boolean isAloneInRow(char[][] matrix, int r) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (matrix[r][i] == 'q') {
                count++;
            }
            if(count == 2){
                return false;
            }
        }

        return true;
    }


    private static boolean isAloneInCol(char[][] matrix, int c) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (matrix[i][c] == 'q') {
                count++;
            }
            if(count == 2){
                return false;
            }
        }

        return true;
    }

    private static boolean isAloneInFirstDiagonal(char[][] matrix, int r, int c) {

        int count = 0;

        for (int i = -7; i <= 7; i++) {

            if (isInRange(r + i, c + i)) {
                if (matrix[r + i][c + i] == 'q') {
                    count++;
                }
            }
            if(count == 2){
                return false;
            }
        }

        return true;
    }

    private static boolean isAloneInSecondDiagonal(char[][] matrix, int r, int c) {

        int count = 0;

        for (int i = -7; i <= 7; i++) {

            if (isInRange(r - i, c + i)) {
                if (matrix[r - i][c + i] == 'q') {
                    count++;
                }
            }
            if(count == 2){
                return false;
            }
        }

        return true;
    }

}
