package LinkedList;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int num){
        stack.push(num);
        if (minStack.isEmpty() || num <= minStack.peek()){
            minStack.push(num);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // Output: -3
        minStack.pop();
        System.out.println(minStack.top());     // Output: 0
        System.out.println(minStack.getMin());  // Output: -2
    }
}
