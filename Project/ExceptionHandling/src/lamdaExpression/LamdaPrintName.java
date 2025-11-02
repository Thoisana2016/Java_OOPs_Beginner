package lamdaExpression;

import java.util.Arrays;
import java.util.List;

public class LamdaPrintName {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Sara", "Cortney");
        names.sort((a,b)-> a.compareToIgnoreCase(b));
        names.forEach(name -> System.out.println("Hello, "+name));
    }

}
