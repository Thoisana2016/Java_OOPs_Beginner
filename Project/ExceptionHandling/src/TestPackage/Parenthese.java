package TestPackage;

import java.util.Stack;

public class Parenthese {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if ((c == '(') || (c == '{') || (c == '[')){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[') ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println("Check Valid Parentheses");
        System.out.println(isValid("{}()[]")); //true
        System.out.println(isValid("{([])}")); //true
        System.out.println(isValid("[{})(]")); //false
    }
}
