package a09_18_MultidimensionalArr_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().split("\\(")[1].replaceAll("\\)",""));

        String input = scanner.nextLine();
        List<String> inputList = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        while(!"END".equals(input)){

           inputList.add(input);

           if(input.length() > maxLength){
               maxLength = input.length();
           }

            input = scanner.nextLine();
        }

        char[][] matrix = new char[inputList.size()][maxLength];

        fillMatrixFromString(matrix, inputList);

        int countRotations = (rotation % 360) / 90;

        for (int i = 0; i < countRotations; i++) {
            matrix = rotateBy90(matrix);
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static char[][] rotateBy90 (char[][] matrix){

        int newR = matrix[0].length;
        int newC = matrix.length;

        char[][] newMatrix = new char[newR][newC];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                newMatrix[j][matrix.length - 1 - i] = matrix[i][j];

            }
        }

        return newMatrix;

    }

    public static void fillMatrixFromString (char[][] matrix, List<String> inputList){

        for (int i = 0; i < matrix.length; i++) {

            String currentString = inputList.get(i);

            for (int j = 0; j < matrix[i].length; j++) {

                if(j < currentString.length()) {

                    matrix[i][j] = currentString.charAt(j);

                } else {

                    matrix[i][j] = ' ';
                }
            }
        }

    }
}
