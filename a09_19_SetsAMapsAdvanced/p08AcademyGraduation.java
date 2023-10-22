package a09_19_SetsAMapsAdvanced;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> graduationMap = new TreeMap<>();


        for (int i = 0; i < count; i++) {

            String name = scanner.nextLine();
            double[] gradesArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            graduationMap.putIfAbsent(name, gradesArr);

        }


        for (Map.Entry<String, double[]> entry : graduationMap.entrySet()) {

            //System.out.printf("%s is graduated with %f%n", entry.getKey(), calculateAverage(entry.getValue()));

            System.out.printf("%s is graduated with %s%n", entry.getKey(), calculateAverage(entry.getValue()));

        }


    }

    public static double calculateAverage (double[] allGrades){

        double totalSum = 0;

        for(double g : allGrades){
            totalSum += g;
        }

        return totalSum / allGrades.length;
    }

}
