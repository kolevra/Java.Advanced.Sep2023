package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

        Deque<String> kidsQueue = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            kidsQueue.offer(inputArr[i]);
        }

        int tosses = Integer.parseInt(scanner.nextLine());

        while(kidsQueue.size() > 1){

            for (int i = 1; i < tosses; i++) {
                kidsQueue.offer(kidsQueue.poll());
            }

            System.out.println("Removed " + kidsQueue.poll());

        }

        System.out.println("Last is " + kidsQueue.poll());

    }
}
