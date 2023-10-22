package a10_02_DefiningClasses_Ex.p06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String trainerName;
    private int badges;
    private List<Pokemon> pokemonList = new ArrayList<>();

    public Trainer(String trainerName, Pokemon currentPokemon) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemonList.add(currentPokemon);
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public boolean isContainsElement(String currentElement) {

        for (Pokemon p : pokemonList) {
            if (p.getElement().equals(currentElement)) {
                return true;
            }
        }
        return false;
    }


    public void reduceHPby10() {

        for (int i = 0; i < pokemonList.size(); i++) {

            pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);

            if (pokemonList.get(i).getHealth() <= 0) {
                pokemonList.remove(i);
                i--;
            }

        }


//        for (Pokemon p : pokemonList) {
//
//            p.setHealth(p.getHealth() - 10);
//
//            if(p.getHealth() <= 0){
//                pokemonList.remove(p);
//            }
//
//        }

    }


}
