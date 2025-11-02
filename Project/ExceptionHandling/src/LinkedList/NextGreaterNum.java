package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNum {

    public static int[] nextGreater(int[] num1, int[] num2){
        Map<Integer, Integer> map = new HashMap<>(); //map for next greater number
        Stack<Integer> stack = new Stack<>();
        for (int n : num2){
            while (!stack.empty() && stack.peek() < n){
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
//        int[] res = new int[num1.length];
        for (int i = 0; i < num1.length; i++){
            num1[i] = map.containsKey(num1[i]) ? map.get(num1[i]) : -1;
        }
        return num1;//res;
    }

    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] res = nextGreater(num1, num2);
        System.out.println("Next Greater number ");
        for (int n : res){
            System.out.print(" "+n);
        }
    }
}
