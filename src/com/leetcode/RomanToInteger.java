package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("III : " + romanToInt("III"));
        System.out.println("D : " + romanToInt("D"));
        System.out.println("XL : " + romanToInt("XL"));
    }

    public static int romanToInt(String s) {

        if (s!=null && s.length() >= 1){
            char[] cs = s.toCharArray();
            int result = 0;
            Stack<Character> cha = new Stack<>();
            for (int i = cs.length-1; i>=0; i--) {
                char c = cs[i];
                if (cha.size() > 0){
                    if (((cha.peek() == 'X' || cha.peek() == 'V')  && c == 'I') ||
                            ((cha.peek() == 'L' || cha.peek() == 'C')  && c == 'X') ||
                            ((cha.peek() == 'D' || cha.peek() == 'M')  && c == 'C'))
                        result -= (2*letterMap.get(c));
                }
                // if (letterMap.containsKey(c)) {
                result += letterMap.get(c);
                //}
                cha.push(c);
            }
            return result;
        }
        return 0;
    }
    private static Map<Character, Integer> letterMap = new HashMap<>();
    static  {
        letterMap.put('I',1);
        letterMap.put('V',5);
        letterMap.put('X',10);
        letterMap.put('L',50);
        letterMap.put('C',100);
        letterMap.put('D',500);
        letterMap.put('M',1000);
    }
}
