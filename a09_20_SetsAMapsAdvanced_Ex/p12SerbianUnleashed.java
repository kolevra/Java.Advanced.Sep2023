package a09_20_SetsAMapsAdvanced_Ex;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p12SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> concertsMap = new LinkedHashMap<>();

        //String regex = "\\b(?<name>[A-Za-z\\s]*)\\s@(?<location>[A-Za-z\\s]*)\\s(?<ticketPrice>[\\d]+)\\s(?<people>[\\d]+)\\b";

        while (!"End".equals(input)) {

            String[] inputArr = input.split(" @");
            String singer = inputArr[0];

            if (inputArr.length > 1) {

                String[] secondSplit = inputArr[1].split("\\s+");

                if (secondSplit.length >= 3 && secondSplit.length <= 5) {

                    if (isNumeric(secondSplit[secondSplit.length - 1]) && isNumeric(secondSplit[secondSplit.length - 2])) {

                        StringBuilder venue = new StringBuilder();

                        if (secondSplit.length == 3) {
                            venue = new StringBuilder(secondSplit[0]);
                        } else {

                            for (int i = 0; i < secondSplit.length - 3; i++) {
                                venue.append(secondSplit[i]).append(" ");
                            }

                            venue.append(secondSplit[secondSplit.length - 3]);

                        }

                        int count = Integer.parseInt(secondSplit[secondSplit.length - 1]);
                        int price = Integer.parseInt(secondSplit[secondSplit.length - 2]);
                        int profit = count * price;

                        concertsMap.putIfAbsent(venue.toString(), new LinkedHashMap<>());
                        LinkedHashMap<String, Integer> performanceMap = concertsMap.get(venue.toString());

                        performanceMap.putIfAbsent(singer, 0);
                        performanceMap.put(singer, performanceMap.get(singer) + profit);

                    }

                } else {
                    input = scanner.nextLine();
                    continue;
                }

            } else {
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }

        concertsMap.forEach((key, value) -> {
            System.out.println(key);

            value.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry ->
                            System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));

        });

    }

    private static boolean isNumeric(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
