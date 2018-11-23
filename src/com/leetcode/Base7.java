package com.leetcode;

public class Base7 {
	    public String convertToBase7(int num) {
	        String re = "" + Math.abs(num)%7;
	        String fo = "";
	        if ((Math.abs(num)/7) > 0) {
	            fo = convertToBase7(num/7);
	        } else {
	            return "" +num%7;
	        }
	        return fo+re;
	    }
}
