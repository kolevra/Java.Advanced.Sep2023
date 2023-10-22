package a10_09_Generics_Ex.CountStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> boxList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(scanner.nextLine());
            boxList.add(box);
        }

        Box<String> stringBox = new Box<>(scanner.nextLine());
        System.out.println(countGreaterElements(boxList, stringBox));

    }

    static <T extends Comparable<T>> int countGreaterElements(List<T> data, T element) {
        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);
            if (res > 0) {
                count++;
            }
        }

        return count;
    }


    static <T> void swap(List<T> data, int firstIndex, int secondIndex) {

        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }

}