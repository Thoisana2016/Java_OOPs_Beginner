package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollection {

    public static void fruit(){
        List<String> food = Arrays.asList("mango","apple","orange");
        List<String> fruitFood = food.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(fruitFood);
    }

    public static void main(String[] args) {
        List<String> upperCase = Arrays.asList("bmw","audi","mercedes","jeep","ford");
        List<String> name = upperCase.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(name);

        System.out.println("Fruit Names : ");
        fruit();
    }

}
