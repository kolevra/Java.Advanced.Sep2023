package a09_20_SetsAMapsAdvanced_Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();


        for (int i = 0; i < input.length(); i++) {

            char currentSymbol = input.charAt(i);

            if (!symbolsMap.containsKey(currentSymbol)) {
                symbolsMap.put(currentSymbol, 1);
            } else {
                int newCount = symbolsMap.get(currentSymbol) + 1;
                symbolsMap.put(currentSymbol, newCount);
            }


        }



        symbolsMap.forEach((key, value) -> System.out.printf("%c: %d time/s\n", key, value));

    }
}
