package a10_02_DefiningClasses_Ex.p04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            String[] tokenArr = scanner.nextLine().split("\\s+");
            String model = tokenArr[0];
            int engineSpeed = Integer.parseInt(tokenArr[1]);
            int enginePower = Integer.parseInt(tokenArr[2]);
            int cargoWeight = Integer.parseInt(tokenArr[3]);
            String cargoType = tokenArr[4];
            double tire1Pressure = Double.parseDouble(tokenArr[5]);
            int tire1Age = Integer.parseInt(tokenArr[6]);
            double tire2Pressure = Double.parseDouble(tokenArr[7]);
            int tire2Age = Integer.parseInt(tokenArr[8]);
            double tire3Pressure = Double.parseDouble(tokenArr[9]);
            int tire3Age = Integer.parseInt(tokenArr[10]);
            double tire4Pressure = Double.parseDouble(tokenArr[11]);
            int tire4Age = Integer.parseInt(tokenArr[12]);

            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Tire currentTire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car currentCar = new Car(model, currentEngine, currentCargo, currentTire);

            carList.add(currentCar);

        }

        String command = scanner.nextLine();

        if("fragile".equals(command)){

            for (Car c : carList) {

                if(c.getCargo().getCargoType().equals("fragile") && c.getTire().isPressureLow()){
                    System.out.println(c.getModel());
                }
            }

        } else {

            for (Car c : carList) {

                if(c.getCargo().getCargoType().equals("flamable") && c.getEngine().isEngineStrong()){
                    System.out.println(c.getModel());
                }
            }
        }
    }
}
