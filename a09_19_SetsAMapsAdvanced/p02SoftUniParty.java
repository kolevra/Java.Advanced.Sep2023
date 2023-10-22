package a09_19_SetsAMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String invited = scanner.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> guests = new TreeSet<>();

        while (!"PARTY".equals(invited)) {

            char category = invited.charAt(0);

            if (Character.isDigit(category)) {
                vip.add(invited);
            } else {
                guests.add(invited);
            }

            invited = scanner.nextLine();
        }


        String attending = scanner.nextLine();


        while (!"END".equals(attending)) {
            vip.remove(attending);
            guests.remove(attending);
            attending = scanner.nextLine();
        }

        int count = vip.size() + guests.size();
        System.out.println(count);

        for (String v : vip) {
            System.out.println(v);
        }

        for (String g : guests) {
            System.out.println(g);
        }

    }
}
