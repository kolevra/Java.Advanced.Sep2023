package a10_02_DefiningClasses_Ex.p03SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double consumption;
    private int distanceTraveled;


    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distanceTraveled = 0;
    }

    public boolean isDrivePossible (int distanceDrive){
        return this.fuel >= this.consumption * distanceDrive * 1.0;
    }

    public void decreaseFuel (int distanceTraveled){
        this.fuel -= this.consumption * distanceTraveled * 1.0;
    }

    public void increaseDistance (int distanceTraveled){
        this.distanceTraveled += distanceTraveled;
    }


    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }

}
