package _Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class e02TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int sizeRow = Integer.parseInt(size[0]);
        int sizeCol = Integer.parseInt(size[1]);

        char[][] matrix = new char[sizeRow][sizeCol];

        int row = -1;
        int col = -1;

        for (int i = 0; i < sizeRow; i++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < sizeCol; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'Y') {
                    row = i;
                    col = j;
                }
            }
        }

        String input = scanner.nextLine();
        List<String> stepsList = new ArrayList<>();

        while (!"Finish".equals(input)) {

            int startR = row;
            int startC = col;

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

            if(!isInRange(matrix, row, col) || matrix[row][col] == 'T'){
                row = startR;
                col = startC;
            } else {
                stepsList.add(input);
            }

            input = scanner.nextLine();
        }

        if(matrix[row][col] == 'X'){
            System.out.println("I've found the treasure!");
            String result = String.join(", ", stepsList);
            System.out.printf("The right path is %s", result);
        } else {
            System.out.println("The map is fake!");
        }

    }

    public static boolean isInRange(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

}
