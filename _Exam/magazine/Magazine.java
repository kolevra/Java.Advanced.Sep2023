package _Exam.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {

    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth){

        if(this.data.size() < capacity){
            this.data.add(cloth);
        }

    }

    public boolean removeCloth(String color){

        Cloth cloth = this.getCloth(color);
        data.remove(cloth);
        return cloth != null;

//        Cloth cloth = this.data.stream()
//                .filter(c -> c.getColor().equals(color))
//                .findFirst()
//                .orElse(null);
//
//        return this.data.remove(cloth);
    }

    public Cloth getSmallestCloth(){

        List<Cloth> sortedBySizeAsc = this.data.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getSize(), c2.getSize()))
                .collect(Collectors.toList());

        return sortedBySizeAsc.get(0);

    }

    public Cloth getCloth(String color){

        Cloth cloth = this.data.stream()
                .filter(c -> c.getColor().equals(color))
                .findFirst()
                .orElse(null);

        return cloth;

    }

    public int getCount(){
        return this.data.size();
    }

    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append(this.type).append(" magazine contains:").append(System.lineSeparator());

//        for (Cloth c : this.data ){
//            sb.append(c.toString()).append(System.lineSeparator());
//        }

        data.forEach(c -> sb.append(c.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }




}
