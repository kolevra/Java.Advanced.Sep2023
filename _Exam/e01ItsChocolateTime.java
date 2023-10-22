package _Exam;

import java.util.*;

public class e01ItsChocolateTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack  = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoStack::push);

        Map<String, Integer> chocolatesMap = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()){

            double currentPercentage = cacaoStack.peek() / (milkQueue.peek() + cacaoStack.pop()) * 100;

            if(currentPercentage == 30.0){
                increaseChocolate(chocolatesMap, "Milk Chocolate");
                milkQueue.poll();

            } else if(currentPercentage == 50.0){
                increaseChocolate(chocolatesMap, "Dark Chocolate");
                milkQueue.poll();

            } else if(currentPercentage == 100.0){
                increaseChocolate(chocolatesMap, "Baking Chocolate");
                milkQueue.poll();

            } else {
                milkQueue.offer(milkQueue.poll() + 10);
            }
        }

        if(chocolatesMap.size() == 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocolatesMap.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }

    }

    public static void increaseChocolate(Map<String, Integer> chocolatesMap, String type){

        chocolatesMap.putIfAbsent(type, 0);
        chocolatesMap.put(type, chocolatesMap.get(type) + 1);

    }

}
