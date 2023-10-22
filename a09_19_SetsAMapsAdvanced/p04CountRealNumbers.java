package a09_19_SetsAMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double :: parseDouble)
                .toArray();


        Map<Double, Integer> numbersCountMap = new LinkedHashMap<>();

        for (int i = 0; i < inputNumbers.length; i++) {

            double currentNUmber = inputNumbers[i];

            numbersCountMap.putIfAbsent(currentNUmber, 0);

            numbersCountMap.put(currentNUmber, numbersCountMap.get(currentNUmber) + 1);

        }


//        for (Map.Entry<Double, Integer> entry : numbersCountMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }

        numbersCountMap.entrySet()
                .forEach(entry -> {
                    System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
                });

    }
}
