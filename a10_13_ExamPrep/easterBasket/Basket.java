package a10_13_ExamPrep.easterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {

    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        Egg egg = this.data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);

        return this.data.remove(egg);
    }

    public Egg getStrongestEgg() {

        List<Egg> eggsSortedByStrengthAsc = this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getStrength(), e2.getStrength()))
                .collect(Collectors.toList());

        return eggsSortedByStrengthAsc.get(eggsSortedByStrengthAsc.size() - 1);

    }

    public Egg getEgg(String color) {

        Egg egg = this.data.stream()
                .filter(e -> e.getColor().equals(color))
                .findFirst()
                .orElse(null);

        return egg;

    }

    public int getCount() {
        return this.data.size();

    }

    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append(this.material).append(" basket contains:").append(System.lineSeparator());
        for(Egg e: this.data){

            sb.append(e.toString()).append(System.lineSeparator());

        }

        return sb.toString().trim();

    }

}
