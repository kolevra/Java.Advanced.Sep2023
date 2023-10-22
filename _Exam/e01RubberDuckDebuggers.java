package _Exam;

import java.util.*;

public class e01RubberDuckDebuggers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeToCompleteQueue = new ArrayDeque<>();
        Deque<Integer> tasksStack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(timeToCompleteQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        Map<String, Integer> duckMap = new LinkedHashMap<>();
        duckMap.put("Darth Vader Ducky", 0);
        duckMap.put("Thor Ducky", 0);
        duckMap.put("Big Blue Rubber Ducky", 0);
        duckMap.put("Small Yellow Rubber Ducky", 0);

        while (!timeToCompleteQueue.isEmpty() && !tasksStack.isEmpty()) {

            int currentProduct = timeToCompleteQueue.peek() * tasksStack.peek();

            if (currentProduct <= 60) {
                increaseDuckCount(duckMap, "Darth Vader Ducky", timeToCompleteQueue, tasksStack);

            } else if (currentProduct <= 120) {
                increaseDuckCount(duckMap, "Thor Ducky", timeToCompleteQueue, tasksStack);

            } else if (currentProduct <= 180) {
                increaseDuckCount(duckMap, "Big Blue Rubber Ducky", timeToCompleteQueue, tasksStack);

            } else if (currentProduct <= 240) {
                increaseDuckCount(duckMap, "Small Yellow Rubber Ducky", timeToCompleteQueue, tasksStack);

            } else {
                tasksStack.push(tasksStack.pop() - 2);
                timeToCompleteQueue.offer(timeToCompleteQueue.poll());

            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        duckMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    public static void increaseDuckCount(Map<String, Integer> map, String name, Deque<Integer> timeQueue, Deque<Integer> tasksStack) {
        map.put(name, map.get(name) + 1);
        timeQueue.poll();
        tasksStack.pop();
    }

}
