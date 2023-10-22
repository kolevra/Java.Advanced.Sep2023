package a09_14_StacksAndQueues_Ex;

import java.util.Scanner;

public class p06RecursiveFibonacciMemorization {

    private static long[] memory;       //global variable
                                        // for long[] default values are zero

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];       // array with size n+1
        long result = getFibonacci(n);

        System.out.println(result);

    }

    public static long getFibonacci(int count) {

        if (count < 2) {
            return 1;
        }

        if (memory[count] != 0) {           // check if the count position is filled and return it
            return memory[count];
        }

        memory[count] = getFibonacci(count - 2) + getFibonacci(count - 1);
        return memory[count];

    }

}
