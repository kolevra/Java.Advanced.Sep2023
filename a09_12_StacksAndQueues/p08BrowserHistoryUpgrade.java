package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> browsingStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();

        while(!input.equals("Home")){

            if(input.equals("back")){

                if(browsingStack.size()>1){
                    forwardStack.push(browsingStack.pop());
                    System.out.println(browsingStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else if(input.equals("forward")){

                if(!forwardStack.isEmpty()){
                    System.out.println(forwardStack.peek());
                    browsingStack.push(forwardStack.pop());

                } else {
                    System.out.println("no next URLs");
                }

            } else {

                System.out.println(input);
                browsingStack.push(input);
                forwardStack.clear();

            }


            input = scanner.nextLine();
        }

    }
}
