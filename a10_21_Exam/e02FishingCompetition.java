package a10_21_Exam;

import java.util.Scanner;

public class e02FishingCompetition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        String input =scanner.nextLine();
        int fishCatch = 0;
        boolean isWhirlpool = false;

        while (!"collect the nets".equals(input)){

            matrix[row][col] = '-';

            switch (input) {
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

            if(!isInRange(matrix, row, col)){
                row = moveOpposite(row, size);
                col = moveOpposite(col, size);
            }

            if(matrix[row][col] == 'W'){
                fishCatch = 0;
                isWhirlpool = true;
                break;
            } else if (matrix[row][col] >= '0' && matrix[row][col] <= '9'){

                fishCatch += matrix[row][col] - 48;
                matrix[row][col] = '-';

            }

            input = scanner.nextLine();
        }

        if(isWhirlpool){
            System.out.printf("You fell into a whirlpool! " +
                    "The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", row, col);
        } else {

            matrix[row][col] = 'S';

            if(fishCatch >= 20){
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - fishCatch);
            }

            if(fishCatch > 0){
                System.out.printf("Amount of fish caught: %d tons.%n", fishCatch);
            }

            printMatrix(matrix);
        }
    }

    public static boolean isInRange(char[][] matrix, int r, int c){
        return r>=0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    public static int moveOpposite(int x, int size){
        if(x < 0){
            return x + size;
        } else if(x == size){
            return x = 0;
        }
        return x;
    }

    public static void printMatrix(char[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

}
