package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryStack = new ArrayDeque<>();

        if (input == 0) {
            System.out.println(0);
        } else {

            while (input != 0) {

                binaryStack.push(input % 2);
                input /= 2;
            }

        }

        while (!binaryStack.isEmpty()){
            System.out.print(binaryStack.pop());
        }

    }
}
