package a09_19_SetsAMapsAdvanced;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> gradesMap = new TreeMap<>();

        for (int i = 0; i < count; i++) {

            String[] studentsArr = scanner.nextLine().split("\\s+");
            String name = studentsArr[0];
            double currentGrade = Double.parseDouble(studentsArr[1]);

            gradesMap.putIfAbsent(name, new ArrayList<>());
            ArrayList<Double> grades = gradesMap.get(name);
            grades.add(currentGrade);

        }

        gradesMap.entrySet()
                .forEach( entry -> {
                    System.out.print(entry.getKey() + " -> ");

                    entry.getValue()
                            .forEach(innerEntry -> {

                                System.out.printf("%.2f ", innerEntry);

                            });

                    System.out.printf("(avg: %.2f)%n", getAverageGrade(entry.getValue()));
                });

    }

    public static double getAverageGrade(ArrayList<Double> list) {

        double sum = 0.0;
        for (Double aDouble : list) {
            sum += aDouble;
        }

        return sum / list.size();

    }
}
