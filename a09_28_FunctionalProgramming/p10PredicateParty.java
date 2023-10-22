package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate;

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!"Party!".equals(input)){

            String[] token = input.split("\\s+");

            String action = token[0];
            String condition = token[1];
            String criteria = token[2];

            if("StartsWith".equals(condition)){
                predicate = s -> s.startsWith(criteria);
            } else if ("EndsWith".equals(condition)){
                predicate = s -> s.endsWith(criteria);
            } else {
                predicate = s -> s.length() == Integer.parseInt(criteria);
            }


            if("Remove".equals(action)){

                guestList.removeIf(predicate);

            } else {

                List<String> guestToDouble = guestList.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());

                guestList.addAll(guestToDouble);

            }

            input = scanner.nextLine();
        }

        if(guestList.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {

            String result = guestList.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!";

            System.out.println(result);

        }


    }
}
