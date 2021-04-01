package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 105
 * s and t consist of English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(n) time?
 */
public class MinimumWindowSubstring {
    public String minWindowOld(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int i = tmap.getOrDefault(c, 0);
            i++;
            tmap.put(c, i);
        }
        char[] sc = s.toCharArray();
        String subStr = null;
        Map<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i <= sc.length-1; i++) {
            int j = i;
            for (; tmap.containsKey(sc[i]) && j <= sc.length-1; j++) {
                if (tmap.equals(smap)) {
                    if (subStr == null || subStr.length() > (j-i)) {
                        subStr = s.substring(i,j);
                    }
                    smap.clear();
                    break;
                }
                if (tmap.containsKey(sc[j])) {
                    int y = tmap.get(sc[j]);
                    int h = smap.getOrDefault(sc[j], 0);
                    if (y > h) {
                        h++;
                        smap.put(sc[j], h);
                    }

                }
            }
            if (tmap.equals(smap)) {
                if (subStr == null || subStr.length() > (j-i)) {
                    subStr = s.substring(i,j);
                }
                smap.clear();
            }
            smap.clear();
        }
        if (subStr == null) return "";
        return subStr;
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int i = tmap.getOrDefault(c, 0);
            i++;
            tmap.put(c, i);
        }
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int i = smap.getOrDefault(c, 0);
            i++;
            smap.put(c, i);
        }
        int start = 0;
        int end =0;
        char[] sc = s.toCharArray();
        if (!contains(smap,tmap)) return "";
        for ( ; start<=s.length()-1; start++) {

            int we = smap.get(sc[start]);
            we--;
            if (we==0) smap.remove(sc[start]);
            else smap.put(sc[start], we);
            if (!contains(smap,tmap)){
                smap.put(sc[start], smap.getOrDefault(sc[start], 0)+1);
                //start -= 2;
                break;
            }
        }
        for ( end = s.length()-1; end >=0; end--) {

            int we = smap.get(sc[end]);
            we--;
            if (we==0) smap.remove(sc[end]);
            else smap.put(sc[end], we);
            if (!contains(smap,tmap)){
                //end += 2;
                break;
            }
        }
        if (start <0 || end+1 > s.length() || start > end+1) return "";
        return s.substring(start, end+1);
    }

    public boolean contains(Map<Character, Integer> smap,Map<Character, Integer> tmap) {
        for (char tk : tmap.keySet()) {
            int sc = smap.getOrDefault(tk, 0);
            int tc = tmap.get(tk);
            if (sc< tc) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("a : " +new MinimumWindowSubstring().minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println("a : " +new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println("a : " +new MinimumWindowSubstring().minWindow("ab", "a"));
        System.out.println(" : " + new MinimumWindowSubstring().minWindow("a", "b"));
        System.out.println("BANC : " + new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
