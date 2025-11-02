package LinkedList;

import java.util.Stack;

public class ValidParenthese {

    public static boolean isValid(String s){
        Stack<Character> ch = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                ch.push(c);
            }
            else {
                if (ch.isEmpty()){
                    return false;
                }
                char top = ch.pop();

                if ((c == ')' && top != '(' ) ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        return ch.isEmpty();
    }
    public static void main(String[] args) {

        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("{[]}"));      // true

    }
}
