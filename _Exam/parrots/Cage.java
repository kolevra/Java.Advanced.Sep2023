package _Exam.parrots;

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
        if (data.size() < capacity) {
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

    public Parrot sellParrot(String name) {

        Parrot parrot = this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (parrot != null) {
            parrot.setAvailable(false);
        }

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {

        List<Parrot> listParrots = new ArrayList<>();

        for (Parrot p : this.data) {
            if (p.getSpecies().equals(species)) {
                listParrots.add(p);
                p.setAvailable(false);
            }
        }

//        this.data.forEach(p -> {
//            if(p.getSpecies().equals(species)){
//                listParrots.add(p);
//                p.setAvailable(false);
//            }
//        });

        return listParrots;

    }

    public int count() {
        return data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":");

        for (Parrot p : this.data) {
            if (p.isAvailable()) {
                sb.append(System.lineSeparator()).append(p.toString());
            }
        }

        return sb.toString();

    }


}
