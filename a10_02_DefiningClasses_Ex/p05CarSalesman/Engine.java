package a10_02_DefiningClasses_Ex.p05CarSalesman;

public class Engine {

    private String engineModel;
    private int enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public Engine(String engineModel, int enginePower, String engineDisplacement, String engineEfficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }
}
