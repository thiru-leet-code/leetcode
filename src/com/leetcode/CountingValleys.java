package com.leetcode;

import java.util.Stack;

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        Stack<Character> s = new Stack<>();
        char[] cr = path.toCharArray();
        boolean isMountain = false;
        int valleyCnt = 0;
        for (char c : cr) {
            if (s.size() == 0 && c== 'U') isMountain = true;
            else if (s.size() == 0 ) isMountain = false;
            if (isMountain) {
                if (c == 'D') s.pop();
                else s.push(c);
            } else {
                if (c == 'D') s.push(c);
                else s.pop();
                if (s.size() == 0) valleyCnt++;
            }
        }
        return valleyCnt;
    }

    public static void main(String[] args) {
        System.out.println(CountingValleys.countingValleys(8, "UDDDUDUU"));
    }
}
