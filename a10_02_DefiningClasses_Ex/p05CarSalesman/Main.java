package a10_02_DefiningClasses_Ex.p05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countModels = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engineMap = new LinkedHashMap<>();

        for (int i = 0; i < countModels; i++) {

            String[] engineInputArr = scanner.nextLine().split("\\s+");
            String model = engineInputArr[0];
            int enginePower = Integer.parseInt(engineInputArr[1]);

            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineInputArr.length == 4) {

                displacement = engineInputArr[2];
                efficiency = engineInputArr[3];

            } else if (engineInputArr.length == 3) {

                String lastEngineInfo = engineInputArr[2];
                char fistSymbol = lastEngineInfo.charAt(0);

                if (fistSymbol >= 48 && fistSymbol <= 57) {

                    displacement = engineInputArr[2];

                } else {

                    efficiency = engineInputArr[2];
                }
            }

            Engine currentEngine = new Engine(model, enginePower, displacement, efficiency);
            engineMap.put(model, currentEngine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < countCars; i++) {

            String[] carsInputArr = scanner.nextLine().split("\\s+");
            String carModel = carsInputArr[0];
            Engine carEngine = engineMap.get(carsInputArr[1]);

            String carWeight = "n/a";
            String carColor = "n/a";

            if(carsInputArr.length == 4){

                carWeight = carsInputArr[2];
                carColor = carsInputArr[3];

            } else if (carsInputArr.length == 3){

                String lastCarInfo = carsInputArr[2];
                char firstSymbol = lastCarInfo.charAt(0);

                if (firstSymbol >= 48 && firstSymbol <= 57) {

                    carWeight = carsInputArr[2];

                } else {

                    carColor = carsInputArr[2];
                }

            }

            Car currentCar = new Car(carModel, carEngine, carWeight, carColor);
            carList.add(currentCar);

        }

            carList.forEach(System.out::print);

    }
}
