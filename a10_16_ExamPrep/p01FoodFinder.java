package a10_16_ExamPrep;

import java.util.*;

public class p01FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Character>> wordsMap = new LinkedHashMap<>();

        wordsMap.put("pear", splitSymbolsToList("pear"));
        wordsMap.put("flour", splitSymbolsToList("flour"));
        wordsMap.put("pork", splitSymbolsToList("pork"));
        wordsMap.put("olive", splitSymbolsToList("olive"));

        Deque<Character> vowelQueue = new ArrayDeque<>();
        Deque<Character> consonantsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> vowelQueue.offer(e.charAt(0)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e -> consonantsStack.push(e.charAt(0)));

        while(!consonantsStack.isEmpty()){

            char currentVowel = vowelQueue.peek();
            char currentConst = consonantsStack.pop();
            vowelQueue.offerLast(vowelQueue.poll());

            for (Map.Entry<String, List<Character>> entry : wordsMap.entrySet()) {
                entry.getValue().remove(Character.valueOf(currentVowel));
                entry.getValue().remove(Character.valueOf(currentConst));
            }
        }

        int wordsFound = 0;
        List<String> completedWords = new ArrayList<>();

        for (Map.Entry<String, List<Character>> entry : wordsMap.entrySet()) {
            if(entry.getValue().size() == 0 ){
                wordsFound++;
                completedWords.add(entry.getKey());
            }
        }

        System.out.println("Words found: " + wordsFound);
        completedWords.forEach(System.out::println);

    }

    public static List<Character> splitSymbolsToList(String word){

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }

        return list;
    }
}
