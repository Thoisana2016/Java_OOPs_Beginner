package streams;

import java.util.Arrays;
import java.util.List;

public class FilterAndPrint {

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(2,5,7,10,12,15);
        num.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

}
