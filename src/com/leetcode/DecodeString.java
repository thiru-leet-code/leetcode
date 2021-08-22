package com.leetcode;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<StringBuffer> si = new Stack<>();
        Stack<StringBuffer> ss = new Stack<>();
        ss.push(new StringBuffer());
        char[] sc = s.toCharArray();
        boolean isPreNumb = false;
        for (int i = 0; i < sc.length; i ++) {
            if ('[' == sc[i]) {
                ss.push(new StringBuffer());
                si.push(new StringBuffer());
                isPreNumb = false;
            } else if ( sc[i]>='0' && sc[i]<= '9') {
                if (!isPreNumb) si.push(new StringBuffer());
                si.peek().append((sc[i]));
                isPreNumb = true;
            }
            else if ((sc[i]>= 'a' && sc[i]<= 'z') || (sc[i]>= 'A' && sc[i]<= 'Z')) {
                ss.peek().append(sc[i]);
                isPreNumb = false;

            } else if (']' == sc[i]) {
                si.pop();
                int y = si.size() > 0 && si.peek().length() >0 ? Integer.parseInt(si.pop().toString()) : 1;
                StringBuffer r = ss.pop();
                for (int e = y; e>0; e--) {
                    ss.peek().append(r);
                }
                isPreNumb = false;
            }
        }
        return ss.pop().toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
