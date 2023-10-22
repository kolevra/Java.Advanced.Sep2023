package a09_19_SetsAMapsAdvanced;

import java.util.*;

public class p07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> fullDataMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");
            String continent = inputArr[0];
            String country = inputArr[1];
            String city = inputArr[2];

            fullDataMap.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> countryMap = fullDataMap.get(continent);
            countryMap.putIfAbsent(country, new ArrayList<>());
            List<String> citiesList = countryMap.get(country);
            citiesList.add(city);


        }

        fullDataMap.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");

                    entry.getValue().entrySet().stream()
                            .forEach(innerEntry -> {

                                String joinedCities = String.join(", ", innerEntry.getValue());

                                System.out.println("  " + innerEntry.getKey() + " -> " + joinedCities);

                            });
                });


//            fullDataMap.forEach((key, value) -> {
//                System.out.println(key + ":");
//
//                value.forEach((key1, value1) -> {
//
//                    String joinedCities = String.join(", ", value1);
//
//                    System.out.println("  " + key1 + " -> " + joinedCities);
//
//                });
//            });


    }
}
