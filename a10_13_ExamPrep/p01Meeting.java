package a10_13_ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int currentMale = malesStack.peek();
            int currentFemale = femalesQueue.peek();

            if (currentFemale <= 0) {
                femalesQueue.poll();
                continue;
            } else if (currentFemale % 25 == 0) {
                femalesQueue.poll();
                if (!femalesQueue.isEmpty()) {
                    femalesQueue.poll();
                }
                continue;
            }

            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            } else if (currentMale % 25 == 0) {
                malesStack.pop();
                if (!malesStack.isEmpty()) {
                    malesStack.pop();
                }
                continue;
            }

            if (currentFemale == currentMale) {
                malesStack.pop();
                femalesQueue.poll();
                matches++;

            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }

        }

        System.out.println("Matches: " + matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String collect = malesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Males left: " + collect);
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String collect = femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + collect);
        }

    }
}
