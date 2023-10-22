package _Exam;

import java.util.Scanner;

public class e02RallyRacing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] inputRow = scanner.nextLine().split("\\s+");
            matrix[i] = inputRow;
        }

        int currentR = 0;
        int currentC = 0;
        int distance = 0;
        boolean isFinished = false;

        String command = scanner.nextLine();

        while(!"End".equals(command)){

            switch (command){

                case "left":
                    currentC--;
                    break;

                case "right":
                    currentC++;
                    break;

                case "up":
                    currentR--;
                    break;

                case "down":
                    currentR++;
                    break;

            }

            distance += 10;

            if(matrix[currentR][currentC].equals("F")){
                matrix[currentR][currentC] = "C";
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                isFinished = true;
                break;
            }


            if(matrix[currentR][currentC].equals("T")){
                matrix[currentR][currentC] = ".";

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        if(matrix[i][j].equals("T")){
                            currentR = i;
                            currentC = j;
                        }

                    }
                }

                matrix[currentR][currentC] = ".";

                distance += 20;

            }

            command = scanner.nextLine();
        }


        matrix[currentR][currentC] = "C";

        if(!isFinished){
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", distance);

      for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }



    }
}
