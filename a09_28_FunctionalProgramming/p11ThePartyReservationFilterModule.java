package a09_28_FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> predicate;

        Map<String, Predicate<String>> mapPredicates = new HashMap<>();

        String input = scanner.nextLine();

        while(!"Print".equals(input)){

            String[] tokens = input.split(";");
            String filterToAdd = input.substring(4);
            String filterToRemove = input.substring(7);

            String command = tokens[0];
            String filter = tokens[1];
            String condition = tokens[2];

            if("Add filter".equals(command)){

                switch (filter){

                    case "Starts with":
                        predicate = e -> e.startsWith(condition);
                        mapPredicates.putIfAbsent(filterToAdd, predicate);
                        break;

                    case "Ends with":
                        predicate = e -> e.endsWith(condition);
                        mapPredicates.putIfAbsent(filterToAdd, predicate);
                        break;

                    case "Length":
                        predicate = e -> e.length() == Integer.parseInt(condition);
                        mapPredicates.putIfAbsent(filterToAdd, predicate);
                        break;

                    case "Contains":
                        predicate = e -> e.contains(condition);
                        mapPredicates.putIfAbsent(filterToAdd, predicate);
                        break;

                }

            } else if("Remove filter".equals(command)){
                mapPredicates.remove(filterToRemove);
            }

            input = scanner.nextLine();
        }

        for (String g : guestsList) {

            boolean isFiltered = false;

            for (Map.Entry<String, Predicate<String>> entry : mapPredicates.entrySet()) {

                if(entry.getValue().test(g)){

                    isFiltered = true;
                    break;

                }

            }

            if(!isFiltered){
                System.out.print(g + " ");
            }
        }



    }
}
