package com.leetcode;

/***
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * Example 4:
 *
 * Input: str1 = "ABCDEF", str2 = "ABC"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class GreatestCommonDivisor {
    public String gcdOfStrings1(String str1, String str2) {
        String ss = str1.length() <= str2.length() ? str1 : str2;
        String ss1 = str1.length() <= str2.length() ? str1 : str2;
        String ls = str1.length() > str2.length() ? str1 : str2;
        int si = 0;
        int ei = ss.length();
        while (ss.trim().length() > 0) {
            String sub = ls.substring(si, ei);
            String sub1 = ss1.substring(si, ei);
            boolean endreached = false;
            while (sub.length() > 0) {
                if (!sub.equals(ss)) break;
                if (!sub1.equals(ss)) break;
                ei +=ss.length();
                si +=ss.length();
                if (ls.length() < ei) break;
                sub = ls.substring(si, ei);
                if (ss1.length() == si) {
                    endreached = true;
                    continue;
                }
                if (!endreached) {
                    if (ss1.length() < ei) break;
                    sub1 = ss1.substring(si, ei);
                }

            }
            if (si == ls.length()) return ss;
            ss = ss.substring(0, ss.length()-1);
             si = 0;
             ei = ss.length();
        }
        return ss;
    }

    public String gcdOfStrings(String str1, String str2) {

        if (str2.length() > str1.length())
            return gcdOfStrings(str2, str1);

        if (str2.equals(str1))
            return str1;

        if (str1.startsWith(str2))
            return gcdOfStrings(str1.substring(str2.length()), str2);

        return "";
    }

    public static void main(String[] args) {
        System.out.println("TAUXX : "+ new GreatestCommonDivisor().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}
