package com.leetcode;

public class LongestPalindromicSubstring {

    /*
    public String longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();
	         for (int i = 0; i <= s.length()-1; i++) {
	             Integer f = counts.get(s.charAt(i));
	             if (f == null) {
	                 f = 0;
	             }
	             f++;
	             counts.put(s.charAt(i), f);
	         }

	        int l =0;
	        System.out.println(counts);
	        int oddCount = 0;
	        boolean firstOdd = false;
	        for  (char key : counts.keySet()) {
	            System.out.println("oddcount" + oddCount);
	            Integer c = counts.get(key);
	            if (c%2 == 0) {
	                l+=c;
	            } else {
	                if (!firstOdd) {
	                    l+=c;
	                    firstOdd = true;
	                } else {
	                    l = l + (c -1);
	                }
	            }
	        }
	        return l;
    }
     */
  /*  public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String max = "";int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            lastIndex = s.lastIndexOf(s.charAt(i),i);
            if (lastIndex < 0) continue;
            String ss = (s.substring(i,las));
            if (isPal(ss)) {
                if (max.length() < ss.length()) {
                    max = ss;
                }
            }
        }
    }*/
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j =i+1;j < s.length(); j++) {
                String ss = (s.substring(i,j));
                if (isPal(ss)) {
                    if (max.length() < ss.length()) {
                        max = ss;
                    }
                }
            }
        }
        return max;
    }

     private boolean isPal(String s) {
        if (s.length() ==1) return true;
        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) return false;
            else return true;
        }
        int m = s.length()%2;
        int t = s.length()/2;
        for (int i = t-1, j = t+m; i >=0  && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
     }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
