package a09_12_StacksAndQueues;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class p07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int tosses = Integer.parseInt(scanner.nextLine());

        Queue<String> priorityQueue = new PriorityQueue<>();

        for (String kid : kids) {
            priorityQueue.offer(kid);
        }

        int cycles = 1;


        while (priorityQueue.size() > 1) {

            for (int i = 1; i < tosses; i++) {

                    priorityQueue.offer(priorityQueue.poll());
            }

            if(!isPrime(cycles)){

                System.out.println("Removed " + priorityQueue.poll());

            } else {

                System.out.println("Prime " + priorityQueue.peek());

            }

            cycles++;
        }

        System.out.println("Last is " + priorityQueue.poll());

    }


    private static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;

    }

}
