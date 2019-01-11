package com.leetcode;
import java.util.*;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

	Example 1:
	
	Input: s = "anagram", t = "nagaram"
	Output: true
	Example 2:
	
	Input: s = "rat", t = "car"
	Output: false
	Note:
	You may assume the string contains only lowercase alphabets.
	
	Follow up:
	What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author thiru
 *
 */
public class ValidAnagram {
	
	    public boolean isAnagram(String s, String t) {
	        if (t.length() != s.length()) {
	            return false;   
	        }
	        Map<Character,Integer> sm = new HashMap<>();
	        Map<Character,Integer> tm = new HashMap<>();
	        int maxl = Math.max(s.length(), t.length());
	        for (int i =0 ; i<=maxl-1; i++) {
	            if (i <= s.length()-1) {
	                int c = sm.getOrDefault(s.charAt(i), 0);
	                c++;
	                sm.put(s.charAt(i),c);
	            }
	            if (i <= t.length()-1) {
	                int c = tm.getOrDefault(t.charAt(i), 0);
	                c++;
	                tm.put(t.charAt(i),c);
	            }
	        }
	        
	        for(char d : tm.keySet()) {
	            if (!sm.containsKey(d)) {
	                return false;
	            } 
	            if (tm.get(d).intValue() != (sm.get(d)).intValue()) {
	                return false;
	            }
	        }
	        return true;
	        
	    }

}
