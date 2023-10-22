package a09_14_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class p01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer :: parseInt)
                .toArray();

        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            numbersStack.push(inputArr[i]);
        }

        while(!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() + " ");
        }


    }
}
