package a09_14_StacksAndQueues_Ex;

import java.util.*;

public class p10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robotsMap = new LinkedHashMap<>();
        Deque<String> robotsQueue = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {

            String[] detailsArr = inputArr[i].split("-");
            String nameRobot = detailsArr[0];
            int shiftRobot = Integer.parseInt(detailsArr[1]);
            robotsMap.put(nameRobot, shiftRobot);
            robotsQueue.offer(nameRobot);
        }

        int[] timeArr = Arrays
                .stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startTimeSeconds = timeArr[0] * 3600 + timeArr[1] * 60 + timeArr[2];

        String input = scanner.nextLine();

        Deque<String> itemsQueue = new ArrayDeque<>();

        while (!input.equals("End")) {

            String currentItem = input;

            itemsQueue.offer(currentItem);

            input = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> workingRobots = new LinkedHashMap<>();

        while (!itemsQueue.isEmpty()) {

            startTimeSeconds++;

            if (!robotsQueue.isEmpty()) {

                String currentItem = itemsQueue.poll();
                String currentRobot = robotsQueue.poll();

                System.out.printf("%s - %s [%s]%n", currentRobot, currentItem, timeSplit(startTimeSeconds));

                workingRobots.put(currentRobot, 0);

            } else {

                itemsQueue.offer(itemsQueue.poll());

            }


            for (Map.Entry<String, Integer> entry : workingRobots.entrySet()) {
                entry.setValue(entry.getValue() + 1);
            }


            for (Map.Entry<String, Integer> entry : workingRobots.entrySet()) {
                for (Map.Entry<String, Integer> robots : robotsMap.entrySet()) {

                    if (entry.getKey().equals(robots.getKey()) && (entry.getValue() == robots.getValue())) {

                        workingRobots.remove(entry.getKey());
                        robotsQueue.offer(entry.getKey());
                        break;

                    }

                }

            }

        }

        System.out.println();
    }

    public static String timeSplit(int secondsInput) {

        int seconds = secondsInput % 60;
        int hours = secondsInput / 3600;
        int minutes = (secondsInput - hours * 3600 - seconds) / 60;

        if (hours > 23) {
            hours -= 24;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
