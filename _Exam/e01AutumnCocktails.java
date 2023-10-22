package _Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class e01AutumnCocktails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] freshnessArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> freshnessStack = new ArrayDeque<>();

        for (int i = 0; i < ingredientsArr.length; i++) {

            if(ingredientsArr[i] != 0){
                ingredientsQueue.offer(ingredientsArr[i]);
            }

        }

        for (int i = 0; i < freshnessArr.length; i++) {

                freshnessStack.push(freshnessArr[i]);
        }

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;


        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()){

            int currentCocktail = ingredientsQueue.peek() * freshnessStack.pop();

            switch (currentCocktail){

                case 150:
                    pearSour++;
                    ingredientsQueue.poll();
                    break;

                case 250:
                    theHarvest++;
                    ingredientsQueue.poll();
                    break;

                case 300:
                    appleHinny++;
                    ingredientsQueue.poll();
                    break;

                case 400:
                    highFashion++;
                    ingredientsQueue.poll();
                    break;

                default:
                    ingredientsQueue.offer(ingredientsQueue.poll() + 5);
                    break;


            }

        }

        int sumIngr = 0;
        boolean isIngredEmpty = true;

        if(!ingredientsQueue.isEmpty()){

            isIngredEmpty = false;
            for (Integer integer : ingredientsQueue) {
                sumIngr += integer;
            }

        }

        if(pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1){
            System.out.println("It's party time! The cocktails are ready!");

            if(appleHinny > 0){
                System.out.println(" # Apple Hinny --> " + appleHinny);
            }
            if(highFashion > 0){
                System.out.println(" # High Fashion --> " + highFashion);
            }
            if(pearSour > 0){
                System.out.println(" # Pear Sour --> " + pearSour);
            }
            if(theHarvest > 0){
                System.out.println(" # The Harvest --> " + theHarvest);
            }

        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if(!isIngredEmpty){
                System.out.println("Ingredients left: " + sumIngr);
            }
            if(appleHinny > 0){
                System.out.println(" # Apple Hinny --> " + appleHinny);
            }
            if(highFashion > 0){
                System.out.println(" # High Fashion --> " + highFashion);
            }
            if(pearSour > 0){
                System.out.println(" # Pear Sour --> " + pearSour);
            }
            if(theHarvest > 0){
                System.out.println(" # The Harvest --> " + theHarvest);
            }

        }




    }
}
