package com.leetcode;
import java.util.*;

/**
 * 
 * Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 * 
 * @author thiru
 *
 */


public class ReverseWordInString {
	
	    public String reverseWords(String s) {
	        if (s == null || s.length() == 0 || s.equals(" ")) return "";
	        Stack<String> reverse = new Stack<>();
	        String curr = "";
	        for(char c : s.toCharArray()) {
	            if (c == ' ') {
	                if (curr.length() > 0) reverse.push(curr);
	                //reverse.push(" ");
	                curr ="";
	            } else {
	                curr +=c;
	            }
	        }
	        if (s.charAt(s.length()-1) != ' ') reverse.push(curr); 
	        String retStr = "";
	        while (reverse.size() > 0) {
	            retStr += reverse.pop();
	            if (reverse.size() > 0) retStr += " ";
	        }
	        return retStr;
	    }
	
	
	public String reverseWordsSplit(String s) {
        if (s == null || s.length() == 0 || s.equals(" ")) return "";
        Stack<String> reverse = new Stack<>();
        String[] sp = s.split(" ");
        for(String c : sp ) {
           if (!c.equals("")) reverse.push(c);
        }
        String retStr = "";
        while (reverse.size() > 0) {
            retStr += reverse.pop();
            if (reverse.size() > 0) retStr += " ";
        }
        return retStr;
    }

}
