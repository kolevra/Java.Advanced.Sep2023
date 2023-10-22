package a10_02_DefiningClasses_Ex.p02CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());


        List<Employee> employeeList = new ArrayList<>();
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        Employee currentEmployee;

        for (int i = 0; i < count; i++) {

            String[] tokenArr = scanner.nextLine().split("\\s+");
            String name = tokenArr[0];
            double salary = Double.parseDouble(tokenArr[1]);
            String position = tokenArr[2];
            String department = tokenArr[3];

            if (tokenArr.length == 4) {
                currentEmployee = new Employee(name, salary, position, department);
            } else if (tokenArr.length == 5) {

                if (tokenArr[4].contains("@")) {

                    String email = tokenArr[4];
                    currentEmployee = new Employee(name, salary, position, department, email);

                } else {

                    int age = Integer.parseInt(tokenArr[4]);
                    currentEmployee = new Employee(name, salary, position, department, age);
                }

            } else {

                String email = tokenArr[4];
                int age = Integer.parseInt(tokenArr[5]);

                currentEmployee = new Employee(name, salary, position, department, email, age);

            }

            employeeList.add(currentEmployee);

            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new ArrayList<>());
                departmentMap.get(department).add(currentEmployee);
            } else {
                departmentMap.get(department).add(currentEmployee);
            }
        }

        Map.Entry<String, List<Employee>> highestDepartment = departmentMap.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    double e1AvgSalary = e1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    double e2AvgSalary = e2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(e2AvgSalary, e1AvgSalary);
                })
                .findFirst()
                .orElse(null);


//        Map.Entry<String, List<Employee>> highestDepartment = employeeList.stream().
//                collect(Collectors.groupingBy(Employee::getDepartment))
//                .entrySet()
//                .stream()
//                .sorted((e1, e2) -> {
//                    double e1AvgSalary = e1.getValue()
//                            .stream()
//                            .mapToDouble(Employee::getSalary)
//                            .average()
//                            .getAsDouble();
//
//                    double e2AvgSalary = e2.getValue()
//                            .stream()
//                            .mapToDouble(Employee::getSalary)
//                            .average()
//                            .getAsDouble();
//
//                    return Double.compare(e2AvgSalary, e1AvgSalary);
//                })
//                .findFirst()
//                .orElse(null);// if there is no first, return empty;


        System.out.printf("Highest Average Salary: %s%n", highestDepartment.getKey());
        highestDepartment.getValue().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);


    }
}
