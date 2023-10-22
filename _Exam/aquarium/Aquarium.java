package _Exam.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.size() < this.capacity) {
            if (!this.fishInPool.contains(fish)) {
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        Fish fish = this.fishInPool.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);

//        return this.fishInPool.remove(fish);

        return this.fishInPool.removeIf(
                f -> f.getName()
                        .equals(name) &&
                        f.getFins() == 5);


    }

    public Fish findFish(String name) {

        return this.fishInPool.stream()
                .filter(f -> f.getName()
                        .equals(name))
                .findFirst()
                .orElse(null);
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aquarium: ")
                .append(this.name)
                .append(" ^ Size: ")
                .append(this.size);

        for (Fish f : this.fishInPool) {
            sb.append(System.lineSeparator())
                    .append(f.toString());
        }

        return sb.toString()
                .trim();

    }


}
