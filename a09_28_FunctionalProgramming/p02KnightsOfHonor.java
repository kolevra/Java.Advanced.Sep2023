package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> title = (s) -> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(title);

    }
}
