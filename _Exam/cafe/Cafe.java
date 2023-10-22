package _Exam.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){

        if(this.employees.size() < this.capacity){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){

        Employee employee = this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);

        return employees.remove(employee);
    }

    public Employee getOldestEmployee(){

        List<Employee> employeeListSortedByAge = this.employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                .collect(Collectors.toList());

        return employeeListSortedByAge.get(0);

    }

    public Employee getEmployee(String name){

        return this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.name);
        for (Employee e : employees){
            sb.append(System.lineSeparator()).append(e.toString());
        }

        return sb.toString();

    }









}
