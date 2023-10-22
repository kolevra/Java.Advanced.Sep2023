package a10_13_ExamPrep;

import java.util.Scanner;

public class p02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        int rowWhite = -1;
        int colWhite = -1;
        int rowBlack = -1;
        int colBlack = -1;

        for (int i = 7; i >= 0; i--) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'w') {
                    rowWhite = i;
                    colWhite = j;
                } else if (matrix[i][j] == 'b') {
                    rowBlack = i;
                    colBlack = j;
                }
            }
        }

        boolean isHitExpected = rowWhite < rowBlack && ((colWhite - 1 == colBlack) || (colWhite + 1 == colBlack));
        boolean isWhiteCaptured = false;
        boolean isBlackCaptured = false;

        while (rowWhite < 7 && rowBlack > 0) {

            if (!isHitExpected) {
                rowWhite++;
                rowBlack--;

            } else {

                if (rowWhite == rowBlack - 1) {
                    rowWhite++;
                    colWhite = colBlack;
                    isBlackCaptured = true;
                    break;
                } else {
                    rowWhite++;
                }

                if (rowWhite == rowBlack - 1) {
                    rowBlack--;
                    colBlack = colWhite;
                    isWhiteCaptured = true;
                    break;
                } else {
                    rowBlack--;
                }
            }
        }

        if (isBlackCaptured) {
            System.out.printf("Game over! White capture on %s.", convertPosition(rowWhite, colWhite));
        } else if (isWhiteCaptured) {
            System.out.printf("Game over! Black capture on %s.", convertPosition(rowBlack, colBlack));
        } else if (rowWhite == 7) {
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", convertPosition(rowWhite, colWhite));
        } else if (rowBlack == 0) {
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", convertPosition(rowBlack, colBlack));
        }

    }

    public static String convertPosition(int r, int c) {
        r++;
        char colSymbol = (char) (97 + c);
        //char colSymbol = (char) ('a' + c);
        return "" + colSymbol + r;
    }
}
