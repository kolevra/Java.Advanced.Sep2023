package a09_20_SetsAMapsAdvanced_Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");

            chemElements.addAll(Arrays.asList(inputArr));

        }

        for(String e : chemElements){
            System.out.print(e + " ");
        }
    }
}
