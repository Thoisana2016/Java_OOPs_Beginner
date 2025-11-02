package streams;

import java.util.Arrays;
import java.util.List;

public class FilterOddUsingStream {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,1,2,3,4,5,6,7,11,8,9,10);
        nums.stream()
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);
    }

}
