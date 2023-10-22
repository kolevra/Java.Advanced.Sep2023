package _Exam;

import java.util.Scanner;

public class e02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeArr = scanner.nextLine().split(",");
        int sizeR = Integer.parseInt(sizeArr[0]);
        int sizeC = Integer.parseInt(sizeArr[1]);

        char[][] matrix = new char[sizeR][sizeC];

        int row = -1;
        int col = -1;
        int countCheese = 0;

        for (int r = 0; r < sizeR; r++) {

            char[] rowArr = scanner.nextLine().toCharArray();
            matrix[r] = rowArr;

            for (int c = 0; c < sizeC; c++) {

                if (rowArr[c] == 'M') {
                    row = r;
                    col = c;
                }

                if (rowArr[c] == 'C') {
                    countCheese++;
                }

            }
        }

        String command = scanner.nextLine();
        int foundCheese = 0;

        while (!"danger".equals(command)) {

            int startR = row;
            int startC = col;
            matrix[row][col] = '*';

            switch (command) {

                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
            }

            if (!isInRange(matrix, row, col)) {
                System.out.println("No more cheese for tonight!");
                matrix[startR][startC] = 'M';
                break;
            }

            if (matrix[row][col] == 'C') {
                matrix[row][col] = 'M';
                foundCheese++;

                if (foundCheese == countCheese) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    break;
                }
            } else if (matrix[row][col] == 'T') {
                matrix[row][col] = 'M';
                System.out.println("Mouse is trapped!");
                break;
            } else if (matrix[row][col] == '@') {
                row = startR;
                col = startC;
                matrix[row][col] = 'M';
            }

            command = scanner.nextLine();
        }

        if("danger".equals(command)){
            System.out.println("Mouse will come back later!");
        }


        printMatrix(matrix);



    }

    public static boolean isInRange(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
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
