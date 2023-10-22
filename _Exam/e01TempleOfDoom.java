package _Exam;

import java.util.*;
import java.util.stream.Collectors;

public class e01TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substancesStack = new ArrayDeque<>();
        List<Integer> chalangesList = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(toolsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substancesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(chalangesList::add);

        boolean isFound = false;

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()){

            int currentProduct = toolsQueue.peek() * substancesStack.peek();

            if(chalangesList.contains(currentProduct)){
                toolsQueue.poll();
                substancesStack.pop();
                chalangesList.remove((Integer) currentProduct);

                if(chalangesList.isEmpty()){
                    isFound = true;
                    break;
                }

            } else {

                toolsQueue.offer(toolsQueue.poll() + 1);
                if((substancesStack.peek() - 1) > 0){
                    substancesStack.push(substancesStack.pop() - 1);
                } else {
                    substancesStack.pop();
                }

            }
        }

        if(isFound){
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if(!toolsQueue.isEmpty()){
            String collect = toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Tools: " + collect);
        }

        if(!substancesStack.isEmpty()){
            String collect = substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Substances: " + collect);
        }

        if(!chalangesList.isEmpty()){
            String collect = chalangesList.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Challenges: " + collect);
        }

    }
}
