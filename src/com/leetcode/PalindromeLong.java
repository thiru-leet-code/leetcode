package com.leetcode;
import java.util.*;

/**
 * 
 * 409. Longest Palindrome
 * 
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


 * @author thiru
 *
 */

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
