package com.leetcode;

import java.util.*;	

public class LongSubStrWithoutRptChar {
	
	    public int lengthOfLongestSubstring(String s) {
	        int max = s.length() == 1? 1:0;
	        LinkedList<Character> subStr = new LinkedList<>();
	        for (int i =0; i <= s.length()-1; i++) {
	            if (!subStr.contains(s.charAt(i))) {
	                subStr.offer(s.charAt(i));
	            } else {
	                if (max < subStr.size()) {
	                    max = subStr.size();
	                }
	                int brk = 0;
	                
	                while(true) {
	                    
	                    if (subStr.pollFirst() == s.charAt(i)) {
	                        break;
	                    } 
	                }
	                subStr.add(s.charAt(i));
	            }
	        }
	        System.out.println(subStr);
	        if (max < subStr.size()) {
	            max = subStr.size();
	        }
	        return max;
	    }
	

}
