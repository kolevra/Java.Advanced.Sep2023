package a09_20_SetsAMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> mailMap = new LinkedHashMap<>();

        while(!"stop".equals(input)){

            String name = input;
            String email = scanner.nextLine();

            if(!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")){

                mailMap.put(name, email);

            }


            input = scanner.nextLine();
        }


//        for (Map.Entry<String, String> entry : mailMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }


        mailMap.forEach((key, value) -> System.out.println(key + " -> " + value));


    }
}
