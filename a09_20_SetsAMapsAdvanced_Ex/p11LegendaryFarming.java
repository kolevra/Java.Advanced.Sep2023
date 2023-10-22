package a09_20_SetsAMapsAdvanced_Ex;

import java.util.*;

public class p11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isObtained = false;

        Map<String, Integer> legendMap = new TreeMap<>();
        legendMap.putIfAbsent("shards", 0);
        legendMap.putIfAbsent("fragments", 0);
        legendMap.putIfAbsent("motes", 0);

        Map<String, Integer> junkMap = new TreeMap<>();

        String itemUsed = "";

        while (!isObtained) {

            String[] inputArr = scanner.nextLine().split("\\s+");

            for (int i = 0; i < inputArr.length; i += 2) {

                int quantity = Integer.parseInt(inputArr[i]);
                String material = inputArr[i + 1].toLowerCase();

                if (isLegendary(material)) {

                    legendMap.put(material, legendMap.get(material) + quantity);
                    if (legendMap.get(material) >= 250) {
                        isObtained = true;
                        legendMap.put(material, legendMap.get(material) - 250);
                        itemUsed = material;
                        break;
                    }

                } else {

                    junkMap.putIfAbsent(material, 0);
                    junkMap.put(material, junkMap.get(material) + quantity);

                }

            }

        }

        switch (itemUsed) {

            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;

        }

        legendMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                        System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));


        junkMap.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value);
        });

    }

    public static boolean isLegendary(String item) {

        boolean isLegendary = false;

        switch (item) {

            case "shards":
            case "fragments":
            case "motes":
                isLegendary = true;
                break;

        }

        return isLegendary;
    }

}
