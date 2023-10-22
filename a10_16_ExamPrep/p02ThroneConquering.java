package a10_16_ExamPrep;

import java.util.Scanner;

public class p02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int sizeRows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeRows][];

        for (int i = 0; i < sizeRows; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int rowP = -1;
        int colP = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    rowP = i;
                    colP = j;
                }
            }
        }

        boolean isHelenaReached = false;
        boolean isParisDead = false;

        while (energy > 0 && !isHelenaReached) {

            String[] input = scanner.nextLine().split("\\s+");
            String direction = input[0];
            int rowS = Integer.parseInt(input[1]);
            int colS = Integer.parseInt(input[2]);

            matrix[rowS][colS] = "S";

            int startR = rowP;
            int startC = colP;

            switch (direction) {
                case "up":
                    rowP--;
                    break;
                case "down":
                    rowP++;
                    break;
                case "left":
                    colP--;
                    break;
                case "right":
                    colP++;
                    break;
            }


            energy--;

            if (isInRange(matrix, rowP, colP)) {

                matrix[startR][startC] = "-";

                if (matrix[rowP][colP].equals("H")) {
                    isHelenaReached = true;
                    matrix[rowP][colP] = "-";
                    break;
                } else if (matrix[rowP][colP].equals("S")) {
                    energy = energy - 2;
                    matrix[rowP][colP] = "P";
                } else {
                    matrix[rowP][colP] = "P";       // not needed?
                }

            } else {
                rowP = startR;
                colP = startC;
            }
        }

        if (energy <= 0 && !isHelenaReached) {
            matrix[rowP][colP] = "X";
            System.out.printf("Paris died at %d;%d.%n", rowP, colP);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }


        printMatrix(matrix);

    }

    public static boolean isInRange(String[][] matrix, int r, int c) {

        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }

    public static void printMatrix (String[][] matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

}
