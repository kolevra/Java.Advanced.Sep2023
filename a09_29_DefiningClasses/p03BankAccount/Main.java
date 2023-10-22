package a09_29_DefiningClasses.p03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<Integer, BankAccount> bankMap = new HashMap<>();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Create".equals(command)) {

                BankAccount currentAccount = new BankAccount();
                bankMap.put(currentAccount.getId(), currentAccount);
                System.out.printf("Account ID%d created%n", currentAccount.getId());

            } else if ("Deposit".equals(command)) {

                int currentId = Integer.parseInt(tokens[1]);
                int depositAmount = Integer.parseInt(tokens[2]);

                if (isAccountExist(bankMap, currentId)) {

                    BankAccount currentAccount = bankMap.get(currentId);
                    currentAccount.deposit(depositAmount);
                    System.out.printf("Deposited %d to ID%d%n", depositAmount, currentId);

                } else {
                    System.out.println("Account does not exist");
                }

            } else if ("SetInterest".equals(command)) {

                double newInterestRate = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(newInterestRate);

            } else if ("GetInterest".equals(command)) {

                int currentId = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                if (isAccountExist(bankMap, currentId)) {

                    BankAccount currentAccount = bankMap.get(currentId);
                    System.out.printf("%.2f%n", currentAccount.getInterest(years));

                } else {
                    System.out.println("Account does not exist");
                }

            }

            input = scanner.nextLine();
        }

    }

    public static boolean isAccountExist(Map<Integer, BankAccount> bankMap, int account) {

        return bankMap.containsKey(account);
    }

}
