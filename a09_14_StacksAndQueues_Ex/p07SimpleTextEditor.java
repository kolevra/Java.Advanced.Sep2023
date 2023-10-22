package a09_14_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        StringBuilder targetTextSB = new StringBuilder();
        Deque<String> textStack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");
            int task = Integer.parseInt(inputArr[0]);

            switch (task) {
                case 1:
                    textStack.push(targetTextSB.toString());
                    targetTextSB.append(inputArr[1]);
                    break;

                case 2:
                    textStack.push(targetTextSB.toString());
                    int eraseCount = Integer.parseInt(inputArr[1]);
                    targetTextSB.delete(targetTextSB.length() - eraseCount, targetTextSB.length());
                    break;

                case 3:
                    int indexToReturn = Integer.parseInt(inputArr[1]);
                    System.out.println(targetTextSB.charAt(indexToReturn - 1));
                    break;

                case 4:
                    targetTextSB.replace(0, targetTextSB.length(), textStack.pop());
                    break;
            }
        }
    }
}
