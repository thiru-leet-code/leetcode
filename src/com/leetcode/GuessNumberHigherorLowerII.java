package com.leetcode;

public class GuessNumberHigherorLowerII {
	class Solution {
	    public int getMoneyAmount(int n) {
	        if (n <=1) {
	           return 0;
	       }
	        if (n <= 2) {
	            return 1;
	        } 
	       return cal(1,n);
	    }
	    
	    private int cal(int start, int end) {
	        if (start>=end) {
	            return 0;
	        }
	        String h = "";
	      
	        int d = (start+end)/2;
	        int fin = Integer.MAX_VALUE;
	        for (int i = d; i <= end; i++) {
	            int cur = i + Math.max(cal(i+1, end), cal(start, i-1));
	            fin = Math.min(fin, cur);
	        }
	        return fin;
	    }
	}
}
