package a09_20_SetsAMapsAdvanced_Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class p01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {

            usernames.add(scanner.nextLine());

        }

        for (String e : usernames) {
            System.out.println(e);
        }

    }
}
