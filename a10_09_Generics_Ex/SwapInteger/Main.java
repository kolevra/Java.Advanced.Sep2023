package a10_09_Generics_Ex.SwapInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Integer>> boxList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));
            boxList.add(box);
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swap(boxList, tokens[0], tokens[1]);
        boxList.forEach(System.out::println);


    }
    static <T> void swap(List<T> data, int firstIndex, int secondIndex) {

        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }

}