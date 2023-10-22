package a09_19_SetsAMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            int firstPlayerDraw = 0;
            for (Integer c : firstDeck) {
                firstPlayerDraw = c;
                break;
            }
            firstDeck.remove(firstPlayerDraw);

            int secondPlayerDraw = secondDeck.iterator().next();
            secondDeck.remove(secondPlayerDraw);

            if(firstPlayerDraw > secondPlayerDraw){
                firstDeck.add(firstPlayerDraw);
                firstDeck.add(secondPlayerDraw);
            } else if (secondPlayerDraw > firstPlayerDraw){
                secondDeck.add(firstPlayerDraw);
                secondDeck.add(secondPlayerDraw);
            }


            if(firstDeck.isEmpty() || secondDeck.isEmpty()){
                break;
            }

        }


        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }


    }
}
