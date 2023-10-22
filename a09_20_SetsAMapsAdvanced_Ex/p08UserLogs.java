package a09_20_SetsAMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        TreeMap<String, LinkedHashMap<String, Integer>> usernamesMap = new TreeMap<>();

        String userRegex = "IP=(?<ip>[\\w\\d.:]*)\\smessage='(?<message>[\\w.&!]*)'\\suser=(?<user>[\\w]+)";
        //String userRegex = "IP=+(?<ip>[0-9A-Z:.]+)+ message+.+user=(?<user>.+)";

        while(!"end".equals(input)){

            Pattern pattern = Pattern.compile(userRegex);
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String address = matcher.group("ip");
                String username = matcher.group("user");
                //System.out.println(address + " " + username);

                if(!usernamesMap.containsKey(username)){

                    usernamesMap.put(username, new LinkedHashMap<>());
                    LinkedHashMap<String, Integer> ipMap = usernamesMap.get(username);
                    ipMap.put(address, 1);

                } else {

                    if(!usernamesMap.get(username).containsKey(address)){

                        usernamesMap.get(username).put(address, 1);

                    } else {

                        int currentCount = usernamesMap.get(username).get(address);

                        usernamesMap.get(username).put(address, currentCount + 1);

                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : usernamesMap.entrySet()) {

            int ipCount = entry.getValue().size();
            int counter = 0;

            System.out.println(entry.getKey() + ": ");

            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {

                counter++;

                if(counter < ipCount){

                    System.out.printf("%s => %d, ", innerEntry.getKey(), innerEntry.getValue());

                } else {

                    System.out.printf("%s => %d.%n", innerEntry.getKey(), innerEntry.getValue());
                }
            }
        }


//        usernamesMap.forEach((key, value) -> {
//
//            System.out.println(key + ":");
//
//            value.forEach ((innerKey, innerValue) -> {
//
//                System.out.print( innerKey + " => " + innerValue + ", ");
//
//            });
//            System.out.println();
//        } );


    }
}
