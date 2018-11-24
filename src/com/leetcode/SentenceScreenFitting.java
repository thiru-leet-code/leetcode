package com.leetcode;

public class SentenceScreenFitting {
	    public int wordsTyping(String[] s, int rows, int cols) {
	        int i =0, c=0, l=0;
	        boolean fetch = false;
	        for (int j =0; j < rows; j++) {
	            if (j>0 && i==0 && !fetch) {
	                int sd = rows/j;
	                if (sd > 0) {
	                    c *= sd;
	                    j *= sd;
	                    j--;
	                }
	                fetch = true;
	            } else 
	            while(s[i].length()+1+l <= cols || (s[i].length()+l == cols)) {
	                l += s[i].length()+1;
	                if (i == (s.length-1)) {
	                    int dd = cols/l;
	                    if (dd > 0 && j== 0) {
	                        c += dd;
	                        l *= dd;
	                    } else
	                        c++;
	                    i=0;
	                } else
	                    i++;
	            }
	            
	            l=0;
	        }
	        return c;
	    }
	
}
