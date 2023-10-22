package _Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class e01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] boxOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer :: parseInt)
                .toArray();

        int[] boxTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer :: parseInt)
                .toArray();


        Deque<Integer> firstQueue = new ArrayDeque<>();
        Deque<Integer> secondStack = new ArrayDeque<>();

        for (int i = 0; i < boxOne.length; i++) {
            firstQueue.offer(boxOne[i]);
        }

        for (int i = 0; i < boxTwo.length; i++) {
            secondStack.push(boxTwo[i]);
        }

        int sum = 0;

        while(!firstQueue.isEmpty() && !secondStack.isEmpty()){

            int currentProduct = firstQueue.peek() + secondStack.peek();

            if(currentProduct % 2 == 0){

                firstQueue.poll();
                secondStack.pop();
                sum += currentProduct;

            } else {

                firstQueue.offer(secondStack.pop());

            }


        }


        if(firstQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if(secondStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(sum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d%n", sum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sum);
        }

    }
}
