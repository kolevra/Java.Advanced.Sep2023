package _Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class e01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequenceOne = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sequenceTwo = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> monsterQueue = new ArrayDeque<>();
        Deque<Integer> soldierStack = new ArrayDeque<>();

        for (int i = 0; i < sequenceOne.length; i++) {
            monsterQueue.offer(sequenceOne[i]);
        }

        for (int i = 0; i < sequenceTwo.length; i++) {
            soldierStack.push(sequenceTwo[i]);
        }

        int powerRemaining = 0;
        int monsterKilled = 0;

        while (!monsterQueue.isEmpty() && !soldierStack.isEmpty()) {

            if (monsterQueue.peek() <= soldierStack.peek() + powerRemaining) {
                powerRemaining = soldierStack.pop() - monsterQueue.poll();
                monsterKilled++;

            } else {
                monsterQueue.offer(monsterQueue.poll() - soldierStack.pop() + powerRemaining);
                powerRemaining = 0;

            }

            if (!monsterQueue.isEmpty() && soldierStack.isEmpty() && powerRemaining > 0) {
                soldierStack.push(powerRemaining);
            }
        }

        if (monsterQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (soldierStack.isEmpty() && powerRemaining == 0) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", monsterKilled);

    }
}
