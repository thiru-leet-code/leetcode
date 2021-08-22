package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {

    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

     */
    public int longestValidParentheses(String s) {
        Stack<Integer> par = new Stack<>();
        int cnt = 0;
        for (int i =0; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if (!par.empty()) {
                    par.pop();
                    cnt +=2;
                }
            } else {
                par.push(cnt);
            }
        }
        if (!par.empty()) return cnt - par.pop();
        return  cnt;
    }
}
