package _Exam.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(data.size() < capacity){
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        Car car = this.data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) &&
                        c.getModel().equals(model))
                .findFirst()
                .orElse(null);

        return this.data.remove(car);
    }

    public Car getLatestCar(){

        return this.data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);

//        if(data.size() > 0){
//
//            List<Car> carListSortedByYear = this.data.stream()
//                    .sorted((c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()))
//                    .collect(Collectors.toList());
//
//            return carListSortedByYear.get(0);
//
//        } else {
//            return null;
//        }

    }

    public Car getCar(String manufacturer, String model){

        return this.data.stream()
                .filter(c-> c.getManufacturer().equals(manufacturer) &&
                        c.getModel().equals(model))
                .findFirst()
                .orElse(null);

    }

    public int getCount(){
        return this.data.size();
    }


    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":");

        for (Car c : this.data){
            sb.append(System.lineSeparator()).append(c.toString());
        }

        return sb.toString().trim();

    }

}
