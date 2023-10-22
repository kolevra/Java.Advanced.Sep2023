package _Exam.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {

    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        Pet pet = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.data.remove(pet);
    }

    public Pet getPet(String name, String owner){

        return this.data.stream()
                .filter(p->p.getName().equals(name) &&
                        p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");

        for (Pet p : this.data){
            sb.append(System.lineSeparator()).append(p.getName()).append(" ").append(p.getOwner());
        }

        return sb.toString();

    }

}
