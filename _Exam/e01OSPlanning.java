package _Exam;

import java.util.*;
import java.util.stream.Collectors;

public class e01OSPlanning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Deque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(threadsQueue::offer);


        int target = Integer.parseInt(scanner.nextLine());

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {

            if (tasksStack.peek() == target) {
                break;
            }

            if (threadsQueue.peek() >= tasksStack.peek()) {
                threadsQueue.poll();
                tasksStack.pop();
            } else {
                threadsQueue.pop();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), target);

        String collect = threadsQueue.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);

    }
}
