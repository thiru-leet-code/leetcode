package com.leetcode;

public class RegEx {

        public boolean isMatch(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
            dp[text.length()][pattern.length()] = true;

            for (int i = text.length(); i >= 0; i--){
                for (int j = pattern.length() - 1; j >= 0; j--){
                    boolean first_match = (i < text.length() &&
                            (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));
                    if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                        dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                    } else {
                        dp[i][j] = first_match && dp[i+1][j+1];
                    }
                }
            }
            return dp[0][0];
        }

        public boolean isMatchMine(String text, String pattern) {
            int i =0;
            int j=0;
            char wc= ' ';
            while (text!= null && i <= text.length()-1 && pattern != null) {
                System.out.println("-" + wc + "-");
                System.out.println("i:" + i + " j:" + j);
                if (j+1 < pattern.length() && pattern.charAt(j+1) == '*') {
                    System.out.println("i:" + i + " j:" + j);
                    if (pattern.charAt(j) == '.' && j+2 == pattern.length()) {
                        return true;
                    } else if (pattern.charAt(j) == '.') {
                        wc = text.charAt(i);
                    }
                    wc = pattern.charAt(j);
                    if (j+2 < pattern.length()) {
                        j = j+2;
                    } else {
                        j = pattern.length()-1;
                    }

                } else if (wc!=' ') {

                    // System.out.println("i:" + i + " j:" + j);
                    if (text.charAt(i) != wc) {
                   /* if (j+1 <= pattern.length() && (j+1 < pattern.length() && pattern.charAt(j+1) == '*')) {
                        wc = pattern.charAt(j);
                        j = j+2;
                    } else */
                   if (j != pattern.length()-1)
                        wc = ' ';
                    } //else {
                        i++;
                   // }
                } else if (j+1 <= pattern.length()
                        && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
                    i++;
                    if (j < pattern.length()-1)
                        j++;
                } /*else if (j == pattern.length() && j >0
                       && (text.charAt(text.length()-1) == pattern.charAt(pattern.length()-1))) {
                return true;
            }*/
                else {
                    System.out.println("i:" + i + " j:" + j);
                    return false;
                }
            }
            System.out.println("*************");
            if (j >= pattern.length()) {
                return true;
            } else {
                while (j <= pattern.length()-1)  {
                    if (pattern.charAt(j) != wc && pattern.charAt(pattern.length()-1) != text.charAt(text.length()-1)) {
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }

        public static void main(String[] a) {
            RegEx re = new RegEx();
            System.out.println(re.isMatch("tcccfaaaab", "t*c*f.*b"));
            System.out.println(re.isMatch("cb", ".*a*b"));
            System.out.println(re.isMatchMine("aaa", "ab*a*c*a"));

        }
}
