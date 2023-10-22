package _Exam;

import java.util.*;
import java.util.stream.Collectors;

public class e01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textileQueue = new ArrayDeque<>();
        Deque<Integer> medicamentStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(textileQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(medicamentStack::push);

        Map<String, Integer> itemsMap = new TreeMap<>();

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {

            int currentSum = medicamentStack.peek() + textileQueue.poll();

            int currentMedicament = medicamentStack.pop();

            if (currentSum == 30) {
                increaseMap(itemsMap, "Patch");

            } else if (currentSum == 40) {
                increaseMap(itemsMap, "Bandage");

            } else if (currentSum == 100) {
                increaseMap(itemsMap, "MedKit");

            } else if (currentSum > 100) {
                increaseMap(itemsMap, "MedKit");
                int remaining = currentSum - 100;
                medicamentStack.push(medicamentStack.pop() + remaining);

            } else {
                medicamentStack.push(currentMedicament + 10);

            }

        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        itemsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                        System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        if (!textileQueue.isEmpty()) {
            String collect = textileQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Textiles left: " + collect);
        }

        if (!medicamentStack.isEmpty()) {
            String collect = medicamentStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Medicaments left: " + collect);
        }

    }

    private static void increaseMap (Map<String, Integer> itemsMap, String item){
        itemsMap.putIfAbsent(item, 0);
        itemsMap.put(item, itemsMap.get(item) + 1);
    }

}
