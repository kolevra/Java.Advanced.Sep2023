package _Exam;

import java.util.Scanner;

public class e02Python {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] inputArr = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        int row = -1;
        int col = -1;
        int countFood = 0;

        for (int i = 0; i < size; i++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 's') {
                    row = i;
                    col = j;
                }
                if (matrix[i][j] == 'f') {
                    countFood++;
                }
            }
        }

        int length = 1;
        boolean isEnemyHit = false;

        for (int i = 0; i < inputArr.length; i++) {

            String currentCommand = inputArr[i];

            switch (currentCommand) {

                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (!isInRange(matrix, row, col)) {

                row = moveOnTheOtherSide(row, size);
                col = moveOnTheOtherSide(col, size);

            }

            if (matrix[row][col] == 'f') {
                length++;
                countFood--;
                if (countFood == 0) {
                    break;
                }
            } else if (matrix[row][col] == 'e') {
                isEnemyHit = true;
                break;
            }

        }

        if (isEnemyHit) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (countFood == 0) {
            System.out.printf("You win! Final python length is %d%n", length);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", countFood);
        }

    }

    public static boolean isInRange(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    public static int moveOnTheOtherSide(int x, int size) {
        if (x < 0) {
            x = x + size;
        } else if (x == size) {
            x = 0;
        }
        return x;
    }
}
