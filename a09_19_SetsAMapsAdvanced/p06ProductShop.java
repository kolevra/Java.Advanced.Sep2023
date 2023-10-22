package a09_19_SetsAMapsAdvanced;

import java.util.*;

public class p06ProductShop {
    public static void main(String[] args) {
        Scanner scanners = new Scanner(System.in);

        String input = scanners.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> shopsMap = new TreeMap<>();

        while (!"Revision".equals(input)) {

            String[] tokensArr = input.split(", ");

            String shop = tokensArr[0];
            String product = tokensArr[1];
            double price = Double.parseDouble(tokensArr[2]);

            shopsMap.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> innerData = shopsMap.get(shop);
            innerData.putIfAbsent(product, price);


            input = scanners.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shopsMap.entrySet()) {
            System.out.println(entry.getKey() + "->");

            for (Map.Entry<String, Double> innerEntry : entry.getValue().entrySet()) {

                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());

            }


        }


    }
}
