package a10_02_DefiningClasses_Ex.p03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {

            String[] token = scanner.nextLine().split("\\s+");

            String model = token[0];
            double fuel = Double.parseDouble(token[1]);
            double consumption = Double.parseDouble(token[2]);

            Car currentCar = new Car(model, fuel, consumption);

            carsMap.put(model, currentCar);
        }

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] inputArr = input.split("\\s+");
            String modelDrive = inputArr[1];
            int distanceDrive = Integer.parseInt(inputArr[2]);

            Car carDrive = carsMap.get(modelDrive);

            if (carDrive.isDrivePossible(distanceDrive)) {

                carDrive.decreaseFuel(distanceDrive);
                carDrive.increaseDistance(distanceDrive);

            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }


        carsMap.values()
                .forEach(System.out::println);


    }

}
