package a10_21_Exam.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid){
        if(this.data.size() < this.capacity){
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name){
        Kid kid = this.data.stream()
                .filter(k -> k.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.data.remove(kid);
    }

    public Kid getKid(String street){
        return this.data.stream()
                .filter(k->k.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }

    public int getAllKids(){
      return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:");

        for (Kid k : this.data){
            sb.append(System.lineSeparator()).append(k.getName()).append(" from ").append(k.getStreet()).append(" street");
        }
        return sb.toString();
    }
}
