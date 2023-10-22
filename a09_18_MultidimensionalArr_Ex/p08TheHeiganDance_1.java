package a09_18_MultidimensionalArr_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p08TheHeiganDance_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double dmg = Double.parseDouble(scanner.nextLine());

        double heiganHP = 3000000;
        int playerHP = 18500;
        int[] position = {7, 7};
        //int[] position = new int[]{7, 7};
        String lastSpell = "";
        int lastX = -1;
        int lastY = -1;
        boolean isWin = false;
        boolean gotHit = false;

        while (heiganHP > 0 && playerHP > 0) {

            List<String> attackArea = new ArrayList<>();
            //          List<String> cloudArea = new ArrayList<>();

            heiganHP -= dmg;
            if (heiganHP <= 0) {
                isWin = true;
                continue;
            }

            if (gotHit) {
                playerHP -= 3500;
                if (playerHP <= 0) {
                    continue;
                }
            }

            String[] inputArr = scanner.nextLine().split("\\s+");
            String spell = inputArr[0];
            lastSpell = spell;
            int xAttack = Integer.parseInt(inputArr[1]);
            int yAttack = Integer.parseInt(inputArr[2]);
            lastX = position[0];
            lastY = position[1];

            attackArea = createDamageArea(xAttack, yAttack);
            position = newPosition(position, attackArea);


            if (position[0] == lastX && position[1] == lastY) {
                if ("Cloud".equals(spell)) {
                    gotHit = true;
                    playerHP -= 3500;
                    //                  cloudArea = createDamageArea(xAttack, yAttack);

                } else {
                    playerHP -= 6000;
                }
            } else {
                gotHit = false;
            }



        }


        if (isWin) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }

        if (playerHP < 0) {
            if("Cloud".equals(lastSpell)){
                System.out.println("Player: Killed by Plague Cloud");
            } else {

                System.out.println("Player: Killed by Eruption");
            }

        } else {
            System.out.println("Player: " + playerHP);

        }

        System.out.printf("Final position: %s, %s", position[0], position[1]);

    }

    public static boolean isInRange(int r, int c) {

        return r >= 0 && r < 15 && c >= 0 && c < 15;

    }

    public static List<String> createDamageArea(int r, int c) {

        List<String> area = new ArrayList<>();

        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {

                if (isInRange(i, j)) {
                    area.add(i + " " + j);
                }

            }
        }

        return area;

    }

    public static boolean isInDamageArea(int[] player, List<String> area) {
        String postionString = player[0] + " " + player[1];

        return area.contains(postionString);

    }


    public static int[] newPosition(int[] player, List<String> area) {

        String postionString = player[0] + " " + player[1];
        int[] finalPosition = new int[2];

        if (area.contains(postionString)) {

            if (!area.contains(player[0] - 1 + " " + player[1]) && isInRange(player[0] - 1, player[1])) {

                finalPosition[0] = player[0] - 1;
                finalPosition[1] = player[1];
                return finalPosition;

            } else if (!area.contains(player[0] + " " + (player[1] + 1))&& isInRange(player[0], player[1] + 1)) {

                finalPosition[0] = player[0];
                finalPosition[1] = player[1] + 1;
                return finalPosition;

            } else if (!area.contains(player[0] + 1 + " " + player[1])&& isInRange(player[0] + 1, player[1])) {

                finalPosition[0] = player[0] + 1;
                finalPosition[1] = player[1];
                return finalPosition;

            } else if (!area.contains(player[0] + " " + (player[1] - 1))&& isInRange(player[0], player[1] -1)) {

                finalPosition[0] = player[0];
                finalPosition[1] = player[1] - 1;
                return finalPosition;

            } else {
                return player;
            }

        }

        return player;

    }
}
