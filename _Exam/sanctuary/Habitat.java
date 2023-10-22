package _Exam.sanctuary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        if (data.size() < capacity){
            this.data.add(elephant);
        }
    }

    public boolean remove(String name){
        Elephant elephant = this.data.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.data.remove(elephant);
    }

    public Elephant getElephant(String retiredFrom){

        return this.data.stream()
                .filter(e->e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant(){

        List<Elephant> elephantListSortedByAge = this.data.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList());

        return elephantListSortedByAge.get(0);
    }

    public int getAllElephants(){
        return this.data.size();
    }

    public String getReport(){

        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:");

        for (Elephant e : this.data){
            sb.append(System.lineSeparator()).append(e.getName()).append(" came from: ").append(e.getRetiredFrom());
        }

        return sb.toString();

    }







}
