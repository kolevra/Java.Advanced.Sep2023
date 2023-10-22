package _Exam;

import java.util.Scanner;

public class e02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsArr = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        int row = -1;
        int col = -1;

        for (int r = 0; r < size; r++) {
            char[] rowArr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[r] = rowArr;
            for (int c = 0; c < rowArr.length; c++) {

                if (rowArr[c] == 'D') {
                    row = r;
                    col = c;
                    break;
                }
            }
        }

        int totalStolen = 0;

        for (int i = 0; i < commandsArr.length; i++) {

            String currentCommand = commandsArr[i];
            int oldR = row;
            int oldC = col;

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

            if(isInRange(matrix, row, col)){
                matrix[oldR][oldC] = '+';
            } else {
                System.out.println("You cannot leave the town, there is police outside!");
                row = oldR;
                col = oldC;
            }

            if(matrix[row][col] == 'P'){
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolen);
                matrix[row][col] = '#';
                break;
            } else if(matrix[row][col] == '$'){
                matrix[row][col] = '+';
                totalStolen += row * col;
                System.out.printf("You successfully stole %d$.%n", row * col);
            }

            if(i == commandsArr.length - 1){
                matrix[row][col] = 'D';
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolen);
            }
        }

        print(matrix);

    }

    private static void print(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder CurrentRow = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                CurrentRow.append(matrix[r][c]).append(" ");
            }
            System.out.println(CurrentRow.toString().trim());
        }
    }

    public static boolean isInRange(char[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }

}
