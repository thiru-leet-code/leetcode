package com.leetcode;
import java.util.*;
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
