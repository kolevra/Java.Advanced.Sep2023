package a09_29_DefiningClasses.p02Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            String[] inputArr = scanner.nextLine().split("\\s+");
            String brand = inputArr[0];

            Car curretnCar;

            if(inputArr.length == 1){

                curretnCar = new Car(brand);

            } else {

                String model = inputArr[1];
                int horsePower = Integer.parseInt(inputArr[2]);
                curretnCar = new Car(brand, model, horsePower);
            }

            carList.add(curretnCar);

        }

        for (Car car : carList) {
            System.out.println(car);
        }



    }
}
