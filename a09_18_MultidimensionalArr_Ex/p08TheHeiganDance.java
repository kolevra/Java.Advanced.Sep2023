package a09_18_MultidimensionalArr_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganHP = 3000000;
        int playerHP = 18500;
        int currentR = 7;
        int currentC = 7;

        double damage = Double.parseDouble(scanner.nextLine());
        boolean isCloud = false;
        boolean isGotHit = false;
        String lastAttack = "";


        while (heiganHP >= 0 && playerHP >= 0) {

            heiganHP -= damage;

            if (isCloud && isGotHit) {
                playerHP -= 3500;
                lastAttack = "Plague Cloud";

                if (playerHP <= 0) {
                    break;
                }
            }

            isCloud = false;
            isGotHit = false;

            if (heiganHP <= 0) {
                break;
            }

            String[] inputArr = scanner.nextLine().split("\\s+");
            String typeAttack = inputArr[0];
            int rAttack = Integer.parseInt(inputArr[1]);
            int cAttack = Integer.parseInt(inputArr[2]);

            int dmgToPlayer = 0;

            if ("Cloud".equals(typeAttack)) {

                dmgToPlayer = 3500;
                isCloud = true;

            } else if ("Eruption".equals(typeAttack)) {

                dmgToPlayer = 6000;
            }


            if (isInDamageArea(currentR, currentC, rAttack, cAttack)) {


                if (!isInDamageArea(currentR - 1, currentC, rAttack, cAttack) && isInMatrixRange(currentR - 1, currentC)) {

                    currentR -= 1;

                } else if (!isInDamageArea(currentR, currentC + 1, rAttack, cAttack) && isInMatrixRange(currentR, currentC + 1)) {

                    currentC += 1;

                } else if (!isInDamageArea(currentR + 1, currentC, rAttack, cAttack) && isInMatrixRange(currentR + 1, currentC)) {

                    currentR += 1;

                } else if (!isInDamageArea(currentR, currentC - 1, rAttack, cAttack) && isInMatrixRange(currentR, currentC - 1)) {

                    currentC -= 1;

                } else {

                    playerHP -= dmgToPlayer;
                    lastAttack = typeAttack;
                    isGotHit = true;

                }

            }

        }

        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }

        if (playerHP <= 0) {
            System.out.printf("Player: Killed by %s%n", lastAttack);
        } else {
            System.out.printf("Player: %d%n", playerHP);
        }

        System.out.println("Final position: " + currentR + ", " + currentC);

    }

    private static boolean isInMatrixRange(int r, int c) {

        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }


    private static boolean isInDamageArea(int playerR, int playerC, int attackR, int attackC) {

        List<String> damageArea = new ArrayList<>();

        for (int i = attackR - 1; i <= attackR + 1; i++) {

            for (int j = attackC - 1; j <= attackC + 1; j++) {

                if (isInMatrixRange(i, j)) {
                    damageArea.add(i + " " + j);
                }
            }
        }

        return damageArea.contains(playerR + " " + playerC);

    }
}
