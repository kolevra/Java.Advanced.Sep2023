package _Exam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if(vehicles.size() < capacity){
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){

        Vehicle vehicle = this.vehicles.stream()
                .filter(v -> v.getVIN().equals(vin))
                .findFirst()
                .orElse(null);

        return this.vehicles.remove(vehicle);

    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){
        List<Vehicle> vehicleListSortedByMileage = this.vehicles.stream()
                .sorted((v1, v2) -> Integer.compare(v1.getMileage(), v2.getMileage()))
                .collect(Collectors.toList());

        return vehicleListSortedByMileage.get(0);
    }


    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        for(Vehicle v : vehicles){
            sb.append(System.lineSeparator()).append(v.toString());
        }

        return sb.toString().trim();

    }


}
