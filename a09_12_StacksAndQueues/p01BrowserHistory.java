package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> browsingStack = new ArrayDeque<>();


        while(!input.equals("Home")){

            if(input.equals("back")){

                if(browsingStack.size()>1){
                    browsingStack.pop();
                    System.out.println(browsingStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else {
                browsingStack.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
