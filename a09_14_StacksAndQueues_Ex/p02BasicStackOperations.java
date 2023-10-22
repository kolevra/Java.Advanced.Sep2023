package a09_14_StacksAndQueues_Ex;

import java.util.*;

public class p02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] tasksArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pushN = tasksArr[0];
        int popS = tasksArr[1];
        int checkX = tasksArr[2];

        int[] inputArr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < pushN; i++) {
            numbersStack.push(inputArr[i]);
        }

        for (int i = 0; i < popS; i++) {
            numbersStack.pop();
        }


        if (numbersStack.contains(checkX)) {
            System.out.println("true");
        } else if(numbersStack.isEmpty()) {
            System.out.println(0);
        } else{
 //           System.out.println(minStackElement(numbersStack));
            System.out.println(Collections.min(numbersStack));
        }

    }

    public static int minStackElement(Deque<Integer> stackToCheck) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stackToCheck.size(); i++) {
            int currentNumber = stackToCheck.pop();
            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        return min;

    }

}
