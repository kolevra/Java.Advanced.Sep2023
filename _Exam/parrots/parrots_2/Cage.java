package _Exam.parrots.parrots_2;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
                this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        return data.remove(parrot);

    }

    public Parrot sellParrot(String name){

        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name) &&
                        p.isAvailable())
                .findFirst()
                .orElse(null);

        if(parrot != null){
            parrot.setAvailable(false);
        }
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species){

        List<Parrot> soldSpecies = new ArrayList<>();

for (Parrot p: this.data){
    if(p.getSpecies().equals(species)){
        soldSpecies.add(p);
        p.setAvailable(false);
    }
}

        return soldSpecies;

    }

    public int count(){
        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":");

        for (Parrot p : this.data){
            if(p.isAvailable()){

                sb.append(System.lineSeparator()).append(p.toString());
            }
        }

        return sb.toString();


    }

}
