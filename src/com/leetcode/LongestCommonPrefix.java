package com.leetcode;

public class LongestCommonPrefix {
    /***
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ) return "";
        String compareto = strs[0];
        for (String s : strs) {
            while (!s.startsWith(compareto)) {
                compareto = compareto.substring(0, compareto.length()-1);
                if (compareto.length() == 0) return "";
            }
        }
        return compareto;

    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
    }
}
