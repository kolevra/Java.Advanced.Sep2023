package _Exam;

import java.util.Scanner;

public class e02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().replaceAll("", "").toCharArray();
        }

        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        int submarineDamage = 0;
        int cruisersHit = 0;

        while (cruisersHit < 3 && submarineDamage < 3) {

            matrix[row][col] = '-';

            String direction = scanner.nextLine();

            switch (direction) {

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

            if(matrix[row][col] == '*'){
                submarineDamage++;
                matrix[row][col] = 'S';

            } else if (matrix[row][col] == 'C'){
                cruisersHit++;
                matrix[row][col] = 'S';
                if(cruisersHit == 3){
                    System.out.println( "Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                }
            }
        }

        if(submarineDamage == 3){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", row, col);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder CurrentRow = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                CurrentRow.append(matrix[r][c]);
            }
            System.out.println(CurrentRow.toString());
        }
    }
}
