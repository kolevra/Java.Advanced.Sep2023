package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class p06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int condition = Integer.parseInt(scanner.nextLine());

        Predicate<String> lengthCheck = s -> s.length() <= condition;


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(lengthCheck)
                .forEach(System.out::println);

    }
}
