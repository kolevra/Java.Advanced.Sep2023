package a09_14_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p06RecursiveFibonacciQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> fiboStack = new ArrayDeque<>();
        fiboStack.offer(0L); // insert first fibo
        fiboStack.offer(1L); // insert second fibo

        if (n < 2) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {

            long n1 = fiboStack.poll();
            long n2 = fiboStack.peek();

            fiboStack.offer(n1 + n2);

        }

        fiboStack.poll();
        System.out.println(fiboStack.peek());
    }
}
