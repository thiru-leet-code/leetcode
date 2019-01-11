package com.leetcode;
/**
 * 
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.

For example, Given S = “eceba”, T is "ece" which its length is 3.

 * @author thiru
 *
 */
public class LongSubStrMost2DistChar {

	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        if (s == null) {
	            return 0;
	        }
	        int max = 0;
	        int fc=0;
	        int sc=0;
	        char[] l2c = new char[2];
	        char last = ' ';
	        int lastCon = 1;
	        System.out.println(s.length());
	         System.out.println("fc" + fc);
	        System.out.println("sc" + sc);
	        int y = 0;
	        double sd = Double.valueOf(y);
	        for ( int i = 0 ; i <= s.length()-1 ; i++) {
	            if  (last == ' ') {
	                last = s.charAt(i);
	            }
	            System.out.println("scl2c[0] -" + l2c[0] + "-");
	            if (l2c[0] == 0) {
	                l2c[0] = s.charAt(i);
	                fc++;
	                 System.out.println("if");
	            } else if (l2c[0]== s.charAt(i)) {
	                fc++;
	                System.out.println(" 1 else if");
	            }
	            else if (l2c[1]== 0) {
	                l2c[1] = s.charAt(i);
	                sc++;
	                System.out.println("2 else if");
	            } else if (l2c[1]==s.charAt(i)) {
	                sc++;
	                System.out.println("3 else if");
	            } else {
	                System.out.println("else");
	                l2c[0] = last;
	                l2c[1] = s.charAt(i);
	                if (max < (fc+sc)) {
	                    max = fc+sc;
	                }
	                fc =lastCon;
	                sc = 1;
	            }
	            if (i >0 && last == s.charAt(i)) {
	                lastCon++;
	            } else if ( i>0 ) {
	                last = s.charAt(i);
	                lastCon = 1;
	            }
	        }
	        System.out.println("fc" + fc);
	        System.out.println("sc" + sc);
	        System.out.println("max" + max);
	        if (max < (fc+sc)) {
	            max = fc+sc;
	        }
	        return max;
	    }
	

}
