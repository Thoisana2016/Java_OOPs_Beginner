package lamdaExpression;

import java.util.Arrays;
import java.util.List;

public class LamdaExpressionWithCollection {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Steve","Alice","Bob");
        names.sort((a,b) -> a.compareTo(b));
        names.forEach(System.out::println);
    }
}
