package a09_20_SetsAMapsAdvanced_Ex;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Long>> fullMap = new LinkedHashMap<>();
        Map<String, Long> countryTotalMap = new LinkedHashMap<>();


        while(!"report".equals(input)) {

            String[] inputArr = input.split("\\|");
            String city = inputArr[0];
            String country = inputArr[1];
            long population = Long.parseLong(inputArr[2]);


            fullMap.putIfAbsent(country, new LinkedHashMap<>());
            fullMap.get(country).put(city, population);

            countryTotalMap.putIfAbsent(country, 0L);

            long oldPopulation = countryTotalMap.get(country);
            countryTotalMap.put(country, oldPopulation + population);


            input = scanner.nextLine();
        }

        System.out.println();

        

//        countryTotalMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .forEach(entry -> {
//                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
//
//                    Map<String, Long> cities = fullMap.get(entry.getKey());
//
//                    cities.entrySet()
//                            .stream()
//                            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
//                            .forEach(innerMapEntry -> System.out.printf("=>%s: %d\n",
//                                    innerMapEntry.getKey(),
//                                    innerMapEntry.getValue()));
//                });


    }
}
