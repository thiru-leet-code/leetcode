package com.leetcode;
import java.util.*;
public class BackspaceStringCompare_stack {

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> ss = new Stack<>();
            Stack<Character> ts = new Stack<>();
            for (char c : S.toCharArray()) {
                if (c == '#') {
                    if (ss.size() > 0) {
                        ss.pop();
                    }
                } else {
                    ss.push(c);
                }
            }

            for (char c : T.toCharArray()) {
                if (c == '#') {
                    if (ts.size() > 0) {
                        ts.pop();
                    }
                } else {
                    ts.push(c);
                }
            }
            if (ss.size() != ts.size()) return false;
            while(ss.size() > 0) {
                if (ss.pop() != ts.pop()) return false;
            }
            return true;
        }
    }

}
