package a09_20_SetsAMapsAdvanced_Ex;

import java.util.*;

public class p07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, HashSet<String>> playersSets = new LinkedHashMap<>();

        while (!"JOKER".equals(input)) {

            String[] nameSplit = input.split(": ");

            String name = nameSplit[0];
            playersSets.putIfAbsent(name, new HashSet<>());

            String[] cardsArr = nameSplit[1].split(", ");
            HashSet<String> cardsSet = playersSets.get(name);
            cardsSet.addAll(Arrays.asList(cardsArr));

            input = scanner.nextLine();
        }


        playersSets.forEach((key, value) -> {
            int currentScore = calculatePoints(value);
            System.out.println(key + ": " + currentScore);

        });


    }

    public static int calculatePoints(Set<String> inputSet) {

        int totalPoints = 0;

        for (String e : inputSet) {
            String cardPower = e.substring(0, e.length() - 1);
            String color = String.valueOf(e.charAt(e.length() - 1));

            totalPoints += checkCardValue(cardPower) * checkCardValue(color);

        }

        return totalPoints;

    }

    public static int checkCardValue(String card) {

        int value = 0;

        switch (card) {
            case "C":
                value = 1;
                break;
            case "2":
            case "D":
                value = 2;
                break;
            case "3":
            case "H":
                value = 3;
                break;
            case "4":
            case "S":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            case "10":
                value = 10;
                break;
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
        };

        return value;

    }

}
