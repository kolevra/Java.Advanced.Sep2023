package _Exam.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){

        if(registry.size() < capacity){
            this.registry.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName){

        Child child = this.registry.stream()
                .filter(c -> c.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);

        return this.registry.remove(child);
    }

    public int getChildrenCount(){
        return this.registry.size();
    }

    public Child getChild(String firstName){

        Child child = this.registry.stream()
                .filter(c -> c.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);

        return child;
    }

    public String registryReport(){

        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        sb.append("Registered children in ").append(this.name).append(":");

        for (Child c: sortedChildren){
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(c.toString());

        }

        return sb.toString().trim();

    }
}
