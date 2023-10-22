package a10_02_DefiningClasses_Ex.p07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personMap = new LinkedHashMap<>();

        Person currentPerson;

        while (!"End".equals(input)) {

            String[] tokensArr = input.split("\\s+");
            String personName = tokensArr[0];
            String category = tokensArr[1];

            if (!personMap.containsKey(personName)) {

                currentPerson = new Person(personName);
                personMap.put(personName, currentPerson);

            }

            switch (category) {

                case "company":

                    String companyName = tokensArr[2];
                    String department = tokensArr[3];
                    double salary = Double.parseDouble(tokensArr[4]);

                    Company currentCompany = new Company(companyName, department, salary);
                    personMap.get(personName).setCurrentCompany(currentCompany);

                    break;

                case "pokemon":

                    String pokemonName = tokensArr[2];
                    String pokemonType = tokensArr[3];

                    Pokemon currentPokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(personName).getPokemonList().add(currentPokemon);

                    break;

                case "parents":

                    String parentName = tokensArr[2];
                    String parentBDay = tokensArr[3];

                    Parents currentParent = new Parents(parentName, parentBDay);
                    personMap.get(personName).getParentsList().add(currentParent);

                    break;

                case "children":

                    String childName = tokensArr[2];
                    String childBDay = tokensArr[3];

                    Children currentChild = new Children(childName, childBDay);
                    personMap.get(personName).getChildrenList().add(currentChild);


                    break;

                case "car":

                    String carModel = tokensArr[2];
                    int carSpeed = Integer.parseInt(tokensArr[3]);

                    Car currentCar = new Car(carModel, carSpeed);
                    personMap.get(personName).setCurrentCar(currentCar);

                    break;

            }

            input = scanner.nextLine();
        }


        String outputName = scanner.nextLine();


        System.out.println(outputName);
        System.out.println("Company:");
        if (personMap.get(outputName).getCurrentCompany() != null) {
            System.out.printf("%s %s %.2f%n", personMap.get(outputName).getCurrentCompany().getCompanyName(), personMap.get(outputName).getCurrentCompany().getDepartment(), personMap.get(outputName).getCurrentCompany().getSalary());
        }
        System.out.println("Car:");
        if (personMap.get(outputName).getCurrentCar() != null) {
            System.out.printf("%s %d%n", personMap.get(outputName).getCurrentCar().getCarModel(), personMap.get(outputName).getCurrentCar().getCarSpeed());
        }
        System.out.println("Pokemon:");
        if (personMap.get(outputName).getPokemonList().size() > 0) {
            for (Pokemon pokemon : personMap.get(outputName).getPokemonList()) {
                System.out.println(pokemon.getPokemonName() + " " + pokemon.getPokemonType());
            }
        }
        System.out.println("Parents:");
        if (personMap.get(outputName).getParentsList().size() > 0) {
            for (Parents parents : personMap.get(outputName).getParentsList()) {
                System.out.println(parents.getParentName() + " " + parents.getParentBDay());
            }
        }
        System.out.println("Children:");
        if(personMap.get(outputName).getChildrenList().size() > 0){
            for (Children children : personMap.get(outputName).getChildrenList()) {
                System.out.println(children.getChildName() + " " + children.getChildBDay());
            }
        }


    }
}
