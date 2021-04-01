package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    static Map<Character, Character> braces = new HashMap();
    static {
        braces.put(')', '(');
        braces.put(']', '[');
        braces.put('}', '{');
    }
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack();
        char[] cr = s.toCharArray();
        for (char c : cr) {
            if (c == '(' || c == '{' || c == '['){
                brackets.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (brackets.size() == 0) return false;
                char cp = brackets.pop();
                if (cp != braces.get(c)) return false;
            }
        }
        if (brackets.size() > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("()");

    }
}
