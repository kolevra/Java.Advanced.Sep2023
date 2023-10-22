package a10_02_DefiningClasses_Ex.p07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String personName;
    private Company currentCompany;
    private Car currentCar;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;

    public Person(String personName) {
        this.personName = personName;
        this.currentCompany = null;
        this.currentCar = null;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public String getPersonName() {
        return personName;
    }

    public Company getCurrentCompany() {
        return currentCompany;
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
