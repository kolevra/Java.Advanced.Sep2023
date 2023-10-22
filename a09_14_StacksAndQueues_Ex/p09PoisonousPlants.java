package a09_14_StacksAndQueues_Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> plantsList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int countDays = 0;
        boolean isRemoved = true;

        while (isRemoved && plantsList.size() > 0) {

            isRemoved = false;
            int plantsAtStart = plantsList.size();

            for (int i = 1; i <= plantsAtStart - 1; i++) {

                int leftPlant = plantsList.get(plantsAtStart - 1 - i);
                int rightPlant = plantsList.get(plantsAtStart - i);

                if (isRightBigger(leftPlant, rightPlant)) {
                    plantsList.remove(plantsAtStart - i);
                    isRemoved = true;

                }
            }

            if (isRemoved) {
                countDays++;
            }
        }

        System.out.println(countDays);

    }

    public static boolean isRightBigger(int left, int right) {
        if (left < right) {
            return true;
        } else {
            return false;
        }

    }

}
