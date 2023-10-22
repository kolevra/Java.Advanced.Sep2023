package _Exam.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {

        if (roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        Person person = this.roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.roster.remove(person);
    }

    public Person getPerson(String name, String hometown) {

        Person person = this.roster.stream()
                .filter(p -> p.getName().equals(name) &&
                        p.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);

        return person;

    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(this.name).append(" are:");

        for (Person p : roster){
            sb.append(System.lineSeparator()).append(p.toString());
        }

        return sb.toString().trim();
    }
}
