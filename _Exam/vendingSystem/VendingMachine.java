package _Exam.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {
    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }


    public int getCount(){
        return this.drinks.size();
    }

    public void addDrink(Drink drink){

        if(drinks.size() < buttonCapacity){
            this.drinks.add(drink);
        }

    }

    public boolean removeDrink(String name){

        Drink drink = this.drinks.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);

        return this.drinks.remove(drink);

//        return this.drinks.removeIf(d -> d.getName().equals(name));

    }


    public Drink getLongest(){

        List<Drink> drinksSortedByVolume = this.drinks.stream()
                .sorted((d1, d2) -> Integer.compare(d2.getVolume(), d1.getVolume()))
                .collect(Collectors.toList());

        return drinksSortedByVolume.get(0);


//        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).orElse(null);

    }



    public Drink getCheapest(){

        Drink drink = this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
        return drink;

//        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);

    }


    public String buyDrink(String name){


//        Optional<Drink> drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst();
//        return drink.map(value -> value.toString().trim()).orElse("");

        Drink drink = this.drinks.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);

        return drink.toString();

    }


    public String report() {


//        StringBuilder sb = new StringBuilder();
//
//        sb.append("Drinks available:\n");
//
//        for (Drink drink : drinks) {
//            sb.append(drink.toString());
//            sb.append("\n");
//        }
//        return sb.toString();


        StringBuilder sb = new StringBuilder();

        sb.append("Drinks available:");

        for (Drink drink : this.drinks) {
            sb.append(System.lineSeparator()).append(drink.toString());
        }
        return sb.toString().trim();
    }


}
