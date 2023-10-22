package a09_14_StacksAndQueues_Ex;

import java.util.*;

public class p04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

        int elementsN = Integer.parseInt(inputArr[0]);
        int toRemoveS = Integer.parseInt(inputArr[1]);
        int checkX = Integer.parseInt(inputArr[2]);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsN; i++) {
            queue.offer(numbersArr[i]);
        }

        for (int i = 0; i < toRemoveS; i++) {
            queue.poll();
        }

        if (queue.contains(checkX)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
