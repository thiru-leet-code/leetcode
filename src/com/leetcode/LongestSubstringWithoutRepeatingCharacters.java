package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] cr = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int st = 0, ed = 0, dif=0;
        int index = 0;
        for (char c: cr) {
            if (m.containsKey(c)) {

                Integer k = m.get(c);
                st = Math.max(st, index - (k +1));

            }
            dif = Math.max(dif, index-st);
                m.put(c, index);

            index++;
        }
        return dif;
    }
}
