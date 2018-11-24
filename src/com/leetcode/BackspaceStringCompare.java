package com.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {
	public boolean backspaceCompareMine(String S, String T) {
        char[] sa = S.toCharArray();
        for (int i = 0; i <= sa.length-1; i++) {
            if (sa[i] == '#') {
                sa[i] = '\u0000';
                int j = i-1;
                while (j>= 0 && sa[j] == '\u0000') {
                    j--;
                }
                if (j >=0) sa[j] = '\u0000';
            }
        }
        char[] ta = T.toCharArray();
       for (int i = 0; i <= ta.length-1; i++) {
            if (ta[i] == '#') {
                ta[i] = '\u0000';
                int j = i-1;
                while (j>= 0 && ta[j] == '\u0000') {
                    j--;
                }
                if (j >=0) ta[j] = '\u0000';
            }
        }
        String saa = "";
        String taa = "";
        for (char s : sa) {
            if (s != '\u0000') {
                saa += s;
            }
        }
        for (char s : ta) {
            if (s != '\u0000') {
                taa += s;
            }
        }
        return saa.equals(taa);
    
    }
	
	    public boolean backspaceCompareWithStack(String S, String T) {
	        return build(S).equals(build(T));
	    }

	    public String build(String S) {
	        Stack<Character> ans = new Stack<>();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }
	    
	    public boolean backspaceCompareWith2Pointer(String S, String T) {
	        char[] s = S.toCharArray();
	        char[] t = T.toCharArray();
	        int sEnd = process(s);
	        int tEnd = process(t);
	        if (sEnd != tEnd) {
	            return false;
	        }
	        for (int i = 0; i < sEnd; i++) {
	            if (s[i] != t[i]) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    private int process(char[] c) {
	        int slow = 0;
	        for (int fast = 0; fast < c.length; fast++) {
	            if (c[fast] != '#') {
	                c[slow++] = c[fast];
	            } else {
	                if (slow != 0) {
	                    slow--;
	                }
	            }
	        }
	        return slow;
	    }
	
}
