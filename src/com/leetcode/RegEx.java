package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegEx {
	    public boolean isMatch(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--){
	            for (int j = pattern.length() - 1; j >= 0; j--){
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));
	                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i+1][j+1];
	                }
	            }
	        }
	        int[] d= new int[2];
	        System.out.println("-"+d[0]+"-");
	        return dp[0][0];
	    }
	
	    public static void main(String[] a) {
	    	RegEx regEx = new RegEx();
	    	System.out.println(regEx.isMatch("coat", "c*at"));
	    }
}
