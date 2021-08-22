package com.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/*
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"


Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 */
public class ReverseSubstringsBetweenEachPairofParentheses {
    public String reverseParentheses(String s) {
        char[] sc = s.toCharArray();
        Stack<Stack<Character>> hold = new Stack<>();
        Stack<Stack<Character>> lhold = new Stack<>();
        lhold.push(new Stack<>());
        boolean fwd = true;
        for (int i =0; i < s.length(); i ++) {
            if ('(' == sc[i] || ')' == sc[i]) {

                if ('(' == sc[i]) {
                    if (fwd) {
                        hold.push(new Stack<>());
                    }else lhold.push(new Stack<>());
                }
                else {
                    if (!fwd) {
                        Stack<Character> e = hold.pop();
                        while (e.size() > 0) lhold.peek().add(e.pop());
                    } else {
                        Stack<Character> e = lhold.pop();
                        while (e.size() > 0) hold.peek().push(e.pop());
                    }
                }
                fwd = !fwd;
            }
            else {
                if (fwd) {
                    lhold.peek().add(sc[i]);
                } else {
                    hold.peek().add(sc[i]);
                }
            }
        }
        StringBuffer sw = new StringBuffer();
        for (char d : lhold.pop()) {
            sw.append(d);
        }

        return sw.toString();

    }
}
