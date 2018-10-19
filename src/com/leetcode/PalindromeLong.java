package com.leetcode;
import java.util.*;
public class PalindromeLong {

	 public int longestPalindrome(String s) {
	        
	        Map<Character, Integer> counts = new HashMap<>();
	         for (int i = 0; i <= s.length()-1; i++) {
	             Integer f = counts.get(s.charAt(i));
	             if (f == null) {
	                 f = 0;
	             }
	             f++;
	             counts.put(s.charAt(i), f);
	         }
	        
	        int l =0;
	        System.out.println(counts);
	        int oddCount = 0;
	        boolean firstOdd = false;
	        for  (char key : counts.keySet()) {
	            System.out.println("oddcount" + oddCount);
	            Integer c = counts.get(key);
	            if (c%2 == 0) {
	                l+=c;
	            } else {
	                if (!firstOdd) {
	                    l+=c;
	                    firstOdd = true;
	                } else {
	                    l = l + (c -1);
	                }
	            }
	        }
	        return l;
	    }
	
}
