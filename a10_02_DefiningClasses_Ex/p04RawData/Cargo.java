package a10_02_DefiningClasses_Ex.p04RawData;

public class Cargo {

    private int cargoWeight;
    private String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }


    public String getCargoType() {
        return cargoType;
    }
}
