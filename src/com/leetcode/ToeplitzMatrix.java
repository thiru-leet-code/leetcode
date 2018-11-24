package com.leetcode;

public class ToeplitzMatrix {
	
	class Solution {
	    public boolean isToeplitzMatrix(int[][] m) {
	        for (int i=1; i <= m.length-1 ; i++) {
	            for (int j=1; j<= m[i].length-1; j++) {
	                if (m[i][j] != m[i-1][j-1]) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	}

}
