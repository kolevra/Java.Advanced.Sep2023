package a10_02_DefiningClasses_Ex.p06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        while (!"Tournament".equals(input)) {

            String[] tokenArr = input.split("\\s+");

            String trainerName = tokenArr[0];
            String pokemonName = tokenArr[1];
            String pokemonElement = tokenArr[2];
            int pokemonHealth = Integer.parseInt(tokenArr[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer currentTrainer = new Trainer(trainerName, currentPokemon);


            if(!trainersMap.containsKey(trainerName)){

                trainersMap.put(trainerName, currentTrainer);

            } else {

                trainersMap.get(trainerName).getPokemonList().add(currentPokemon);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while(!"End".equals(input)){

            String elementAttack = input;

            for (Map.Entry<String, Trainer> trainerEntry : trainersMap.entrySet()) {

                if(trainerEntry.getValue().isContainsElement(elementAttack)){
                    trainerEntry.getValue().setBadges(trainerEntry.getValue().getBadges() + 1);
                } else {
                    trainerEntry.getValue().reduceHPby10();
                }
            }
            input = scanner.nextLine();
        }


        trainersMap.values()
                        .stream()
                                .sorted((t1, t2) -> Integer.compare(t2.getBadges(),t1.getBadges()))
                                        .forEach(t -> System.out.printf("%s %d %d%n", t.getTrainerName(), t.getBadges(), t.getPokemonList().size()));


    }
}
