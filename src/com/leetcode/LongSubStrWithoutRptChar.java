package com.leetcode;

import java.util.*;	

/**
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



 * 
 * @author thiru
 *
 */


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
