package a09_20_SetsAMapsAdvanced_Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class p02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }


        //firstSet.retainAll(secondSet);


        for (int e : firstSet) {

            if(secondSet.contains(e)){
                System.out.print(e + " ");
            }

        }


    }
}
