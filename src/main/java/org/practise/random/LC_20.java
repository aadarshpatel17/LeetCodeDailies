package org.practise.random;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC_20 {

    // 20. Valid Parentheses

    public static void main(String[] args) {
        String str = "()[]{}";
        String str1 = "())";
        System.out.println(isValid_optimize(str1));
        System.out.println(isValid_optimize(str));
    }

    public static boolean isValid_optimize(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(')');
            }
            else if(s.charAt(i) == '{') {
                stack.push('}');
            }
            else if(s.charAt(i) == '[') {
                stack.push(']');
            } else {
                if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && ((stack.peek() == '(' && s.charAt(i) == ')')
                        || (stack.peek() == '{' && s.charAt(i) == '}')
                        || (stack.peek() == '[' && s.charAt(i) == ']'))
                ) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
