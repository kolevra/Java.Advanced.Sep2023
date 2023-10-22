package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputArr = input.split("\\s+");

        Deque<String> calculationsStack = new ArrayDeque<>();

        for (int i = inputArr.length - 1; i >= 0; i--) {
            calculationsStack.push(inputArr[i]);
        }

        //       Collections.addAll(calculationsStack, inputArr);

        while (calculationsStack.size() > 1) {

            int fist = Integer.parseInt(calculationsStack.pop());
            String operation = calculationsStack.pop();
            int second = Integer.parseInt(calculationsStack.pop());

            switch (operation) {
                case "+":
                    calculationsStack.push(fist + second + "");
                    break;

                case "-":
                    calculationsStack.push(fist - second + "");
                    break;

            }

        }

        System.out.println(calculationsStack.pop());

    }
}
