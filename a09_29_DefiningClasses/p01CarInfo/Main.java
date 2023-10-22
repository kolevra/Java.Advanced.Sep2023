package a09_29_DefiningClasses.p01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");

            String brand = inputArr[0];
            String model = inputArr[1];
            int horsePower = Integer.parseInt(inputArr[2]);

            Car currentCar = new Car();

            currentCar.setBrand(brand);
            currentCar.setModel(model);
            currentCar.setHorsePower(horsePower);

            System.out.println(currentCar);

        }

    }
}
