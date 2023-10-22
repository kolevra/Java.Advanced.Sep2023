package a09_12_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class p05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> filesQueue = new ArrayDeque<>();

        while (!input.equals("print")){

            if(!input.equals("cancel")){
                filesQueue.offer(input);

            } else {

                if(!filesQueue.isEmpty()){
                    System.out.println("Canceled " + filesQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }

            }

            input = scanner.nextLine();
        }

        while (!filesQueue.isEmpty()){
            System.out.println(filesQueue.poll());
        }

    }
}
