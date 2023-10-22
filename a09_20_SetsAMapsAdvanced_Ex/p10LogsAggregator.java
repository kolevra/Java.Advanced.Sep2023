package a09_20_SetsAMapsAdvanced_Ex;

import java.util.*;

public class p10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeSet<String>> usersMap = new TreeMap<>();
        Map<String, Integer> durationMap = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");

            String ip = inputArr[0];
            String name = inputArr[1];
            int duration = Integer.parseInt(inputArr[2]);

            usersMap.putIfAbsent(name, new TreeSet<>());
            TreeSet<String> ipSet = usersMap.get(name);
            ipSet.add(ip);

            durationMap.putIfAbsent(name, 0);
            durationMap.put(name, durationMap.get(name) + duration);


        }

        for (Map.Entry<String, Integer> entry : durationMap.entrySet()) {
            System.out.printf("%s: %d ", entry.getKey(), entry.getValue());
            String name = entry.getKey();

            System.out.printf("%s%n", usersMap.get(name));

//            System.out.print("[");
//            int counter = 1;
//            for (String a : usersMap.get(name)) {
//
//                System.out.print(a);
//                if (counter < usersMap.get(name).size()) {
//                    System.out.print(", ");
//                }
//                counter++;
//            }
//
//            System.out.println("]");

        }

    }
}
