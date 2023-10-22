package a09_14_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class p03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s++");
            int action = Integer.parseInt(inputArr[0]);

            switch (action){

                case 1:
                    numbersStack.push(Integer.parseInt(inputArr[1]));
                   break;

                case 2:
                    numbersStack.pop();
                    break;

                case 3:
                    System.out.println(Collections.max(numbersStack));
                    break;


            }

        }

    }
}
