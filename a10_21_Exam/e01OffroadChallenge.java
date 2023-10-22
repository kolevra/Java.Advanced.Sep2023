package a10_21_Exam;

import java.util.*;

public class e01OffroadChallenge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> fuelStack = new ArrayDeque<>();
        Deque<Integer> consumptionQueue = new ArrayDeque<>();
        Deque<Integer> targetQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(fuelStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(consumptionQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(targetQueue::offer);

        List<String> reachedList = new ArrayList<>();
        boolean isFail = false;

        for (int i = 1; i <= 4; i++) {

            int currentResult = fuelStack.pop() - consumptionQueue.poll();
            String currentAlt = "Altitude " + i;

            if (currentResult >= targetQueue.poll()) {
                reachedList.add(currentAlt);
                System.out.printf("John has reached: %s%n", currentAlt);
            } else {
                isFail = true;
                System.out.printf("John did not reach: %s%n", currentAlt);
                break;
            }

            if (i == 4) {
                System.out.println("John has reached all the altitudes and managed to reach the top!");
            }

        }

        if (isFail) {
            System.out.println("John failed to reach the top.");

            if (reachedList.isEmpty()) {

                System.out.println("John didn't reach any altitude.");
            } else {
                String result = String.join(", ", reachedList);
                System.out.println("Reached altitudes: " + result);
            }

        }

    }
}
