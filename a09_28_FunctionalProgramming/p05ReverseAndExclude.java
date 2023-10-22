package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());

        int divisor = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = n -> n % divisor == 0;

        numbersList.removeIf(isDivisible);

        Collections.reverse(numbersList);

        Consumer<List<Integer>> print = list -> list.forEach( e -> System.out.print(e + " "));

        print.accept(numbersList);

    }
}
