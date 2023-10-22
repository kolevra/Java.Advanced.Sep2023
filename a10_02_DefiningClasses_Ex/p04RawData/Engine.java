package a10_02_DefiningClasses_Ex.p04RawData;

public class Engine {

    private int engineSpeed;
    private int enginePower;

    public Engine(int speed, int power) {
        this.engineSpeed = speed;
        this.enginePower = power;
    }

    public boolean isEngineStrong(){
        return enginePower > 250;
    }
}
