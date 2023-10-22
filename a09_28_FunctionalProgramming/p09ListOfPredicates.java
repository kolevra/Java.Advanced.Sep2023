package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperNumber = Integer.parseInt(scanner.nextLine());

        List<Integer> divisorsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> predicate = n -> {

            for (Integer i : divisorsList) {
                if (n % i != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= upperNumber ; i++) {
            if(predicate.test(i)){
                System.out.print(i + " ");
            }

        }

//        for (int i = 1; i <= upperNumber ; i++) {
//
//            boolean isValid = true;
//
//            for (int j = 0; j < divisorsList.size(); j++) {
//
//                Integer currentNumber = divisorsList.get(j);
//
//                if(i % currentNumber != 0){
//                    isValid = false;
//                    break;
//                }
//
//            }
//
//            if(isValid){
//                System.out.print(i + " ");
//            }
//        }

    }
}
