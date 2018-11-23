package com.leetcode;

import java.util.*;

public class IsomorphicStrings {
	    public boolean isIsomorphic(String s, String t) {
	       Map<Character,List<Integer>> sm = new HashMap<>();
	        Map<Character,List<Integer>> tm = new HashMap<>();
	        for (int i = 0; i <= s.length()-1; i++) {
	            List<Integer> sl = sm.getOrDefault(s.charAt(i), new ArrayList<>());
	            sl.add(i);
	            sm.put(s.charAt(i), sl);
	            List<Integer> tl = tm.getOrDefault(t.charAt(i), new ArrayList<>());
	            tl.add(i);
	            tm.put(t.charAt(i), tl);
	        }
	        for (int i = 0; i <= s.length()-1; i++) {
	            List<Integer> ss = sm.get(s.charAt(i));
	            List<Integer> ts = tm.get(t.charAt(i));
	            
	            if (!ss.equals(ts)) {
	                return false;
	            }
	        }
	        return true;
	        
	    }
}
