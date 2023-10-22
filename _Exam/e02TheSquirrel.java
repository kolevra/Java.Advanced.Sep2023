package _Exam;

import java.util.Scanner;

public class e02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsArr = scanner.nextLine().split(", ");

        char[][] matrix = new char[size][size];

        int row = -1;
        int col = -1;

//        for (int i = 0; i < size; i++) {
//            char[] arr = scanner.nextLine().toCharArray();
//            for (int j = 0; j < size; j++) {
//                matrix[i][j] = arr[j];
//                if (matrix[i][j] == 's') {
//                    row = i;
//                    col = j;
//                }
//            }
//        }

        for (int r = 0; r < size; r++) {
            char[] rowArr = scanner.nextLine().toCharArray();
            matrix[r] = rowArr;

            for (int c = 0; c < size; c++) {

//                if(currentRow.contains("P")){
//                    row = currentRow;
//                    col = currentRow.indexOf("P");
//                }

                if (rowArr[c] == 's') {
                    row = r;
                    col = c;
                    break;
                }
            }
        }


        int countHazelnuts = 0;

        for (int i = 0; i < commandsArr.length; i++) {

            matrix[row][col] = '*';

            String currentCommand = commandsArr[i];

            switch (currentCommand) {

                case "left":
                    col--;
                    break;

                case "right":
                    col++;
                    break;

                case "down":
                    row++;
                    break;

                case "up":
                    row--;
                    break;
            }

            if(!isInRange(matrix, row, col)){
                System.out.println("The squirrel is out of the field.");
                break;
            }

            if(matrix[row][col] == 'h'){
                countHazelnuts++;
            }

            if(countHazelnuts == 3){
                System.out.println("Good job! You have collected all hazelnuts!");
                break;
            }

            if(matrix[row][col] == 't'){
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            }

            if(i == commandsArr.length - 1){
                System.out.println("There are more hazelnuts to collect.");
            }

        }

        System.out.printf("Hazelnuts collected: %d", countHazelnuts);

    }

    public static boolean isInRange(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

}
