package _Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class e01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] caffeineArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] drinksArr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> drinksQueue = new ArrayDeque<>();

        for (int i = 0; i < caffeineArr.length; i++) {

            caffeineStack.push(caffeineArr[i]);
        }

        for (int i = 0; i < drinksArr.length ; i++) {

            drinksQueue.offer(drinksArr[i]);
        }

        int stamatConsumedCoff = 0;

        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()){

            int currentDose = caffeineStack.pop() * drinksQueue.peek();

            if((stamatConsumedCoff + currentDose) <= 300){

                stamatConsumedCoff += currentDose;
                drinksQueue.poll();

            } else {

                if((stamatConsumedCoff -30) < 0){
                    stamatConsumedCoff = 0;
                } else {
                    stamatConsumedCoff -= 30;
                }

                drinksQueue.offer(drinksQueue.poll());
            }
        }

        if(!drinksQueue.isEmpty()){

            String queueString = String.join(", ", drinksQueue.toString());

            System.out.println(queueString);

            String test = String.join(", ", Arrays.asList(drinksQueue.toString()));
            System.out.println(test);

            queueString = queueString.replaceAll("[\\[\\]]","");
            System.out.printf("Drinks left: %s%n", queueString);

        } else {

            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatConsumedCoff);
    }
}
