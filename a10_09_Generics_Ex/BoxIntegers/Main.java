package a10_09_Generics_Ex.BoxIntegers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Box<Integer> box = new Box<>(Integer.parseInt(scanner.nextLine()));
            System.out.println(box.toString());
        }


    }
}