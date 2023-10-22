package _Exam;

import java.util.*;
import java.util.stream.Collectors;

public class e01KAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> platesQueue = new ArrayDeque<>();
        Deque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(platesQueue::offer);

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(carsStack::push);

        int countDays = 0;
        int countCars = 0;

        while(!platesQueue.isEmpty() && !carsStack.isEmpty()){

            countDays++;

            int currentCars = 0;

            if(platesQueue.peek() == carsStack.peek() * 2){
                currentCars = platesQueue.poll() / 2;
                carsStack.pop();
            } else if (platesQueue.peek() > carsStack.peek() * 2){
                currentCars = carsStack.peek();
                platesQueue.offer(platesQueue.poll() - carsStack.pop()  * 2);
            } else {
                currentCars = platesQueue.peek() / 2;
                carsStack.addLast(carsStack.pop() - platesQueue.poll() / 2);
            }

            countCars += currentCars;

        }

        System.out.printf("%d cars were registered for %d days!%n", countCars, countDays);

        if(!platesQueue.isEmpty()){
            System.out.printf("%d license plates remain!%n", sumDeque(platesQueue));
        }

        if(!carsStack.isEmpty()){
            System.out.printf("%d cars remain without license plates!%n", sumDeque(carsStack));
        }

        if(platesQueue.isEmpty() && carsStack.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }

    public static int sumDeque (Deque<Integer> sequence){

        int sum = 0;
        List<Integer> listElements = sequence.stream().collect(Collectors.toList());

        for (int i = 0; i < listElements.size(); i++) {
            sum += listElements.get(i);
        }
        return sum;
    }

}
