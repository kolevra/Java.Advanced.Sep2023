package a09_19_SetsAMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while(!"END".equals(input)){

            String[] array = input.split(", ");

            String direction = array[0];
            String regNumber = array[1];

            if("IN".equals(direction)){
                parkingLot.add(regNumber);
            } else {
                parkingLot.remove(regNumber);
            }

            input = scanner.nextLine();

        }

        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String reg : parkingLot) {
                System.out.println(reg);
            }
        }
    }
}
