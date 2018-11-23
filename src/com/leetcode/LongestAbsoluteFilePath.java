package com.leetcode;

import java.util.Stack;

public class LongestAbsoluteFilePath {
	
	class Solution {
	    public int lengthLongestPath(String input) {
	        String[] lines = input.split("\n");
	        Stack<String> ar = new Stack<>();
	        int maxd = 0;
	        int currd = 0;
	        for (String l : lines) {
	            String e = l;
	            if (l.contains(".")) {
	                System.out.println("Ar size : " + ar.size());
	                int tc= 0;
	                while (e.startsWith("\t")) {
	                    tc++;
	                    e = e.substring(1);
	                }
	                System.out.println("Tc : " + tc);
	                while(tc != ar.size()) {
	                    System.out.println("Tc : ..");
	                    ar.pop();
	                }
	                System.out.println("ar : " + ar);
	                if (ar.size()>0) {
	                    if (maxd < ar.peek().length() + e.length() +1) 
	                        maxd = ar.peek().length() + e.length() +1;
	                } else {
	                     if (maxd < e.length()) 
	                        maxd = e.length();
	                }
	                
	            } else {
	                int tc= 0;
	                while (e.startsWith("\t")) {
	                    tc++;
	                    e = e.substring(1);
	                }
	                while(tc != ar.size()) {
	                    ar.pop();
	                } 
	                String pre = "";
	                if (ar.size() != 0) {
	                    pre = ar.peek() + "/" + e;
	                } else pre = l;
	                ar.push(pre);
	            }
	        }
	        return maxd;
	    }
	}

}
