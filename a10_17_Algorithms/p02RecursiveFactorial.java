package a10_17_Algorithms;

import java.util.Scanner;

public class p02RecursiveFactorial {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long result = calculateFactorial(n);

        System.out.println(result);
    }

    private static long calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * calculateFactorial(n - 1);

    }
}
