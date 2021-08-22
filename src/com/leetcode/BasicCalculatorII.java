package com.leetcode;

import java.util.Stack;

/*
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<String> pi = new Stack<>();
        char[] sc = s.toCharArray();
        for (int i = s.length() - 1 ; i >=0  ; i--) {
            if (sc[i] != ' ') {
                if (pi.size() > 0 && (pi.peek().equals("+") ||
                        pi.peek().equals("-") ||
                        pi.peek().equals("*") ||
                        pi.peek().equals("/") )) {
                    String op = pi.pop();
                    String st = "";
                    while (pi.size() >0 && (pi.peek().equals("+") ||
                            pi.peek().equals("-") ||
                            pi.peek().equals("*") ||
                            pi.peek().equals("/") )) {
                        st += pi.pop();
                    }
                    int y = Integer.valueOf(st);
                    st = "";
                    while (i == 0 || sc[i] == '+'||
                            sc[i] != '-' ||
                            sc[i] != '*' ||
                            sc[i] != '/' ) {
                        st += sc[i];
                        i--;
                    }
                    int x = Integer.parseInt(st);
                    int ans = 0;
                    switch (op)  {
                        case "+" :
                            ans = x+y; break;
                        case "-" :
                            ans = x-y; break;
                        case "*" :
                            ans = x*y; break;
                        case "/" :
                            ans = x/y; break;
                    }
                    pi.push(""+ans);
                } else {
                    pi.push(String.valueOf(sc[i]));
                }
            }

        }
        String st = "";
        while (pi.size() >0 && (pi.peek().equals("+") ||
                pi.peek().equals("-") ||
                pi.peek().equals("*") ||
                pi.peek().equals("/") )) {
            st += pi.pop();
        }
        return Integer.valueOf(st);
    }

    public static void main(String[] r) {
        System.out.println(new BasicCalculatorII().calculate("3/2"));
    }
}
