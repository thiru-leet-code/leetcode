package com.leetcode;

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
