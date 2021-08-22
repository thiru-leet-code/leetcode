package com.leetcode;
/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"


Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int s1 = num1.length()-1;
        int s2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (s1 >= 0 || s2 >=0) {
            int c1 = 0;
            if (s1 >=0) {
                c1 = num1.charAt(s1);
                c1 = c1- '0';
            }

            int c2 = 0;
            if (s2 >=0 ) {
                c2 = num2.charAt(s2);
                c2 = c2- '0';
            }

            int val = c1 +c2+carry;
            carry = val/10;
            sb.insert(0,val%10);
             s1--;
            s2--;
        }
        if (carry > 0) sb.insert(0,carry);
        return sb.toString();
    }
}
