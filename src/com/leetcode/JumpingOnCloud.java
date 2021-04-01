package com.leetcode;

public class JumpingOnCloud {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int i = 0;
        int jumps = 0;
        while ( i<= c.length-3) {
            if (c[i+2] ==0) {
                i +=2;
            } else {
                i++;
            }
            jumps++;
        }
        if (i != c.length-1) jumps++;
        return jumps;
    }
}
