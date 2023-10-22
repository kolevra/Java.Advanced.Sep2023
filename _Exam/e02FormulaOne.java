package _Exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class e02FormulaOne {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int count   = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int row = -1;
        int col = -1;

        for (int i = 0; i < size; i++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'P') {
                    row = i;
                    col = j;
                }
            }
        }

        Deque<String> commandsQueue = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            commandsQueue.offer(scanner.nextLine());
        }
        boolean isWin = false;
        boolean isBonus = false;

        while(!commandsQueue.isEmpty()) {

            String input = commandsQueue.peek();

            int startR = row;
            int startC = col;

            matrix[row][col] = '.';

            if(isBonus){
                matrix[row][col] = 'B';
                isBonus = false;
            }

            switch (input){

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

                if(row < 0){
                    row += size;
                } else if (row == size){
                    row -= size;
                }

                if(col < 0){
                    col += size;
                } else if (col == size){
                    col -= size;
                }

            } else {

                if(matrix[row][col] == 'F'){
                    matrix[row][col] = 'P';
                    System.out.println("Well done, the player won first place!");
                    isWin = true;
                    break;
                } else if (matrix[row][col] == 'B'){
                    isBonus = true;
                    continue;
                } else if (matrix[row][col] == 'T'){    // not sure what to do!
                    row = startR;
                    col = startC;
                }
            }
            matrix[row][col] = 'P';

            commandsQueue.pop();


        }

        if(!isWin){
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);

    }

    public static boolean isInRange(char[][] matrix, int r, int c){
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
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
