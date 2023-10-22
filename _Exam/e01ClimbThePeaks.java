package _Exam;

import java.util.*;

public class e01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrFood = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arrStamina = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> foodStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

//        Arrays.stream(scanner.nextLine().split(", "))
//                .map(Integer::parseInt)
//                .forEach(foodStack::push);

        for (int i = 0; i < arrFood.length; i++) {
            foodStack.push(arrFood[i]);
        }

        for (int i = 0; i < arrStamina.length; i++) {
            staminaQueue.offer(arrStamina[i]);
        }


        List<Integer> peaksList = new ArrayList<>(List.of(80, 90, 100, 60, 70));
        List<String> peaksNameList = List.of("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza");
        int countPeaks = 0;

        for (int i = 0; i < 7; i++) {

            int currentSum = foodStack.pop() + staminaQueue.poll();

            if (currentSum >= peaksList.get(0)) {

                peaksList.remove(0);
                countPeaks++;

            }

            if (countPeaks == 5) {
                break;
            }
        }

        if (countPeaks == 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");

        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (countPeaks > 0) {
            System.out.println("Conquered peaks:");
        }

        for (int i = 0; i < countPeaks; i++) {

            System.out.println(peaksNameList.get(i));

        }

        System.out.println();

    }
}
