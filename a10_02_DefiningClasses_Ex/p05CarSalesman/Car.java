package a10_02_DefiningClasses_Ex.p05CarSalesman;

import org.w3c.dom.ls.LSOutput;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine.getEngineModel()).append(":").append(System.lineSeparator());
        sb.append("Power: ").append(this.engine.getEnginePower()).append(System.lineSeparator());
        sb.append("Displacement: ").append(this.engine.getEngineDisplacement()).append(System.lineSeparator());
        sb.append("Efficiency: ").append(this.engine.getEngineEfficiency()).append(System.lineSeparator());
        sb.append("Weight: ").append(this.weight).append(System.lineSeparator());
        sb.append("Color: ").append(this.color).append(System.lineSeparator());

        return sb.toString();
    }


}
