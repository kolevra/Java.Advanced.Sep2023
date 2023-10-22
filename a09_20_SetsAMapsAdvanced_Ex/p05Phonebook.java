package a09_20_SetsAMapsAdvanced_Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input)) {

            String[] inputArr = input.split("-");

            String name = inputArr[0];
            String number = inputArr[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        String nameToSearch = scanner.nextLine();

        while (!"stop".equals(nameToSearch)){

            if(phonebook.containsKey(nameToSearch)){
                System.out.println(nameToSearch + " -> " + phonebook.get(nameToSearch));
            } else {
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            }


            nameToSearch = scanner.nextLine();
        }


    }
}
