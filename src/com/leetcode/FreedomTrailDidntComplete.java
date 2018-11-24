package com.leetcode;

public class FreedomTrailDidntComplete {
	class Solution {
	    
	    int fwd(int st, String r, char c) {
	        int i = st;
	        for (; i<=r.length()-1; i++) {
	            if (r.charAt(i)==c) {
	                break;
	            }
	        }
	        if (i==0) return 0;
	        return i;
	    }
	    int rev(int st, String r, char c) {
	        int i = st;
	        for (; i>=0; i--) {
	            if (r.charAt(i)==c) {
	                break;
	            }
	        }
	        System.out.println(" st : " + st + " i : " + i);
	        return st-i+1;
	    }
	    String reform(String r, int index) {
	        if (index==0) {
	            return r;
	        }
	        String fs = "";
	        System.out.println(r);
	        for (int i = index; i <= r.length()-1; i++) {
	            fs +=r.charAt(i);
	        }
	        for (int i = 0; i <= index-1; i++) {
	            fs +=r.charAt(i);
	        }
	        return fs;
	    }
	    public int findRotateSteps(String ring, String key) {
	        int start =0;
	        int revStart = ring.length()-1;
	        int step = 0;
	        for (int i=0; i<=key.length()-1; i++) {
	            int f = fwd(start, ring, key.charAt(i));
	            int r = rev(revStart, ring, key.charAt(i));
	            
	            int m = Math.min(f,r);
	            if (m == f) {
	                ring = reform(ring, f);
	            } else {
	                ring = reform(ring, (ring.length()-r));
	            }
	            step += m;
	            step++;
	            System.out.println("key.charAt(i)" + key.charAt(i) + " Step : " + step + " m : " + m + " Ring : " + ring);
	        }
	        return step;
	    }
	}

}
