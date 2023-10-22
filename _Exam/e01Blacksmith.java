package _Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class e01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrSteel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arrCarbon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        for (int i = 0; i < arrSteel.length; i++) {
            steelQueue.offer(arrSteel[i]);
        }

        for (int i = 0; i < arrCarbon.length; i++) {
            carbonStack.push(arrCarbon[i]);
        }

        int sabreCount = 0;
        int katanaCount = 0;
        int shamshirCount = 0;
        int gladiusCount = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int currentSum = steelQueue.poll() + carbonStack.peek();

            switch (currentSum) {

                case 70:
                    gladiusCount++;
                    carbonStack.pop();
                    break;

                case 80:
                    shamshirCount++;
                    carbonStack.pop();
                    break;

                case 90:
                    katanaCount++;
                    carbonStack.pop();
                    break;

                case 110:
                    sabreCount++;
                    carbonStack.pop();
                    break;

                default:
                    carbonStack.push(carbonStack.pop() + 5);
                    break;
            }

        }

        int totalSwords = gladiusCount + shamshirCount + katanaCount + sabreCount;

        if(totalSwords > 0){
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if(steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        } else {
            String queueString = String.join(", ", steelQueue.toString());
            queueString = queueString.replaceAll("[\\[\\]]","");
            System.out.print("Steel left: ");
            System.out.println(queueString);
        }

        if(carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            String stackString = String.join(", ", carbonStack.toString());
            stackString = stackString.replaceAll("[\\[\\]]","");
            System.out.print("Carbon left: ");
            System.out.println(stackString);
        }

        if(gladiusCount > 0){
            System.out.printf("Gladius: %d%n",gladiusCount);
        }

        if(katanaCount > 0){
            System.out.printf("Katana: %d%n",katanaCount);
        }

        if(sabreCount > 0){
            System.out.printf("Sabre: %d%n",sabreCount);
        }

        if(shamshirCount > 0){
            System.out.printf("Shamshir: %d%n",shamshirCount);
        }





    }
}
