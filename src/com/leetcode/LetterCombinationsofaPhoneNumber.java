package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 */
public class LetterCombinationsofaPhoneNumber {
    static Map<Character, String[]> map = new HashMap<>();

    static  {
        map.put('2', new String[]{"a","b","c"});
        map.put('3', new String[]{"e","d","f"});
        map.put('4', new String[]{"g","h","i"});
        map.put('5', new String[]{"j","k","l"});
        map.put('6', new String[]{"m","n","o"});
        map.put('7', new String[]{"p","q","r","s"});
        map.put('8', new String[]{"t","u","v"});
        map.put('9', new String[]{"w","x","y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> pre = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for (int i =0; i < digits.length(); i ++) {
            String[] curS = map.get(digits.charAt(i));
            if (pre.size() >0 ) {
                for (String s : pre) {
                    for (String se : curS) {
                        cur.add(s+se);
                    }
                }
                pre = cur;
                cur = new ArrayList<>();

            } else {
                for (String s : curS) {
                    pre.add(s);
                }
            }
        }
        return pre;
    }
}
