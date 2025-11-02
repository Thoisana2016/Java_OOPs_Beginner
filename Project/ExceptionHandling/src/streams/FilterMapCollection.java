package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapCollection {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        List<Integer> surNum = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(surNum);
        System.out.println("Square all numbers : ");
        squreNums(nums);
    }

    public static void squreNums(List<Integer> arr){
        List<Integer> sqrNum = arr.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Square Nums : ");
        System.out.println(sqrNum);
    }

}
