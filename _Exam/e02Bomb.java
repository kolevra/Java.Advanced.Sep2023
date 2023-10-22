package _Exam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class e02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commandsArr = scanner.nextLine().split(",");
        Deque<String> commandsQueue = new ArrayDeque<>();
        for (int i = 0; i < commandsArr.length; i++) {
            commandsQueue.offer(commandsArr[i]);
        }

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        int row = -1;
        int col = -1;
        int countBombs = 0;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                }

                if (matrix[i][j].equals("B")) {
                    countBombs++;
                }
            }
        }

        boolean isAllFound = false;
        boolean isEndReached = false;

        while (!commandsQueue.isEmpty()) {

            String currentCommand = commandsQueue.poll();

            switch (currentCommand) {

                case "left":
                    col--;
                    break;

                case "right":
                    col++;
                    break;

                case "up":
                    row--;
                    break;

                case "down":
                    row++;
                    break;
            }

            row = positionCheck(size, row);
            col = positionCheck(size, col);

            if (matrix[row][col].equals("B")) {
                System.out.println("You found a bomb!");
                matrix[row][col] = "+";
                countBombs--;

            } else if (matrix[row][col].equals("e")) {
                System.out.printf("END! %d bombs left on the field", countBombs);
                isEndReached = true;
                break;
            }

            if (countBombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
                isAllFound = true;
                break;
            }
        }

        if (!isAllFound && !isEndReached) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countBombs, row, col);
        }

    }

    private static int positionCheck(int size, int toCheck) {

        if (toCheck < 0) {
            toCheck = 0;
        } else if (toCheck == size) {
            toCheck = size - 1;
        }

        return toCheck;
    }
}
