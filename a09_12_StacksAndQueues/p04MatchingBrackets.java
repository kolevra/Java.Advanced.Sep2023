package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p04MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> indexOpeningStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                indexOpeningStack.push(i);
            } else if(input.charAt(i) == ')'){

                System.out.println(input.substring(indexOpeningStack.pop(), i + 1));

            }
        }

    }
}
