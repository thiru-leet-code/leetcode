package com.leetcode;

public class LicenseKeyFormating {
	
	    public String licenseKeyFormatting(String S, int k) {
	        char[] sc = S.toUpperCase().toCharArray();
	        char[] finalStr = new char[sc.length + (sc.length/k)];
	        for (int i = sc.length-1, j = finalStr.length-1, z=0; i >= 0; i--) {
	            if (sc[i] != '-') {
	                z++;
	                finalStr[j] = sc[i];
	                if (z == k) {
	                    z=0;
	                    j--;
	                    finalStr[j] = '-';
	                }
	                j--;
	            }
	        }
	        String fd = "";
	        for (char t : finalStr) {
	            if ((fd.equals("") && t == '-')) {
	                continue;
	            }
	            if (t !=0) {
	                fd += "" + t;
	            }
	        }
	        return fd;
	        
	    }
	    
	    public String licenseKeyFormattingOpt(String S, int K) {
	        // Replacing all - and converting all letters to uppercase
	        String S1 = S.replace("-","").toUpperCase();
	        
	        // Making stringBuilder 
	        StringBuilder sb = new StringBuilder(S1);
	       
	        int len = sb.toString().length();
	        // Inserting '-' from back at every K position
	        for(int i=K; i < len; i=i+K) {
	                sb.insert(len-i,'-');
	            }
	        return sb.toString();   
	    }
	
}
