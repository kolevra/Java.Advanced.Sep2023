package _Exam;

import java.util.*;
import java.util.stream.Collectors;

public class e01PastryShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> foodMap = new LinkedHashMap<>();

        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        boolean isBiscuit = false;
        boolean isCake = false;
        boolean isPastry = false;
        boolean isPie = false;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){

            int currentSum = liquidsQueue.poll() + ingredientsStack.peek();

            switch (currentSum){

                case 25:
                    increaseFoodMap(foodMap, "Biscuit");
                    ingredientsStack.pop();
                    isBiscuit = true;
                    break;

                case 50:
                    increaseFoodMap(foodMap, "Cake");
                    ingredientsStack.pop();
                    isCake = true;
                    break;

                case 75:
                    increaseFoodMap(foodMap, "Pastry");
                    ingredientsStack.pop();
                    isPastry = true;
                    break;

                case 100:
                    increaseFoodMap(foodMap, "Pie");
                    ingredientsStack.pop();
                    isPie = true;
                    break;

                default:
                    ingredientsStack.push(ingredientsStack.pop() + 3);
                    break;
            }

        }

        if(isBiscuit && isPastry && isCake && isPie){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            String collect = liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + collect);
        }


        if(ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            String collect = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + collect);
        }

        foodMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    public static void increaseFoodMap (Map<String, Integer> map, String food){

        map.put(food, map.get(food) + 1);

    }

}
