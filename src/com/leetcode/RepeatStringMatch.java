package com.leetcode;

/**
 * 
 * 686. Repeated String Match
 * 
 * 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.


 * 
 * 
 * 
 * @author thiru
 *
 */


public class RepeatStringMatch {

public int repeatedStringMatchOptimal(String A, String B) {
        
        StringBuilder sb = new StringBuilder(A);
        int times = 1;
        
        while (sb.length() < B.length()) {
            sb.append(A);
            times++;
        }
        if (sb.indexOf(B) != -1)
            return times;
        sb.append(A);
        times++;
        
        return sb.indexOf(B) == -1 ? -1 : times;
    }

    public int repeatedStringMatch(String A, String B) {
        int j =-1;
        int cnt =0;
        for (int i =0; i <= B.length()-1; i++) {
            if (cnt==0) {
                if (A.contains(B.substring(0,i+1))) {
                    continue;
                } else if (i == 0) {
                    return -1;
                } else {
                    cnt++;
                    i--;
                    boolean sd = false;
                    while (!A.equals(B.substring(0,i+1)) && !A.endsWith(B.substring(0,i+1))) {
                        i--;
                        sd = true;
                    }
                    while (!A.equals(B.substring(0,i+1)) && (i-1) >= 0 && A.endsWith(B.substring(0,i+1)) && A.startsWith(B.substring(i-1,i+1))) {
                        i--;
                    }
                    j=0;
                }
            } else {
                if (A.charAt(j) == B.charAt(i)) {
                    if (j == A.length()-1) {
                        cnt++;
                        j=0;
                    } else {
                        j++;
                    }
                } else {
                    return -1;
                }
            }
        }
        if (j == -1) return 1;
        if (j >0) cnt++;
        return cnt;
    }

}
