package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * You may assume that both strings contain only lowercase letters.
 */

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rm = new HashMap();
        char[] rc = ransomNote.toCharArray();
        for (char c : rc) {
            int cnt = rm.getOrDefault(c, 0);
            cnt++;
            rm.put(c, cnt);
        }
        rc = magazine.toCharArray();
        for (char c: rc) {
            if (rm.containsKey(c)) {
                int cnt = rm.get(c);
                if (cnt >0) cnt--;
                if (cnt <= 0) {
                    rm.remove(c);
                } else rm.put(c, cnt);
                if (rm.size() ==0) break;
            }

        }

        return rm.size() ==0;
    }

    public boolean canConstructNew(String ransomNote, String magazine) {
        Map<Character, Integer> rm = new HashMap();
        Map<Character, Integer> mm = new HashMap();
        char[] rc = ransomNote.toCharArray();
        for (char c : rc) {
            int cnt = rm.getOrDefault(c, 0);
            cnt++;
            rm.put(c, cnt);
        }
        rc = magazine.toCharArray();
        for (char c: rc) {
            int cnt = mm.getOrDefault(c, 0);
            cnt++;
            mm.put(c, cnt);
        }
        for (char c : rm.keySet()) {
            if (!mm.containsKey(c)) return false;
            int mc = mm.get(c);
            if (mc<rm.get(c)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstructNew("aa", "ab"));
    }
}
