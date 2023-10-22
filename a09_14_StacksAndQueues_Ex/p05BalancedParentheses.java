package a09_14_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Character> openingStack = new ArrayDeque<>();

        if (input.length() % 2 == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {

                openingStack.push(currentSymbol);

            } else {

                char openingToCheck = openingStack.pop();

                switch (currentSymbol) {

                    case ')':

                        if (openingToCheck != '(') {
                            System.out.println("NO");
                            return;
                        }

                        break;

                    case '}':

                        if (openingToCheck != '{') {
                            System.out.println("NO");
                            return;
                        }

                        break;

                    case ']':

                        if (openingToCheck != '[') {
                            System.out.println("NO");
                            return;
                        }

                        break;
                }

            }
        }

        System.out.println("YES");

    }
}
