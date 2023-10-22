package a09_28_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> smallestNumber = arr -> {
            return Arrays.stream(arr)
                    .min((a, b) -> Integer.compare(a, b))
                    .get();
        };

        Integer[] numbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer result = smallestNumber.apply(numbersArr);

        for (int i = numbersArr.length - 1; i >= 0; i--) {
            if (numbersArr[i] == result) {
                System.out.println(i);
                return;
            }
        }

//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        int minNumber = numbers.stream()
//                .mapToInt(e -> e)
//                .min().getAsInt();
//
//        Function<List<Integer>, Integer> findIndex = item -> {
//            return item.lastIndexOf(minNumber);
//        };
//
//        System.out.println(findIndex.apply(numbers));

    }
}
