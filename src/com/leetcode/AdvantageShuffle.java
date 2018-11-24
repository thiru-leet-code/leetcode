package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] returnA = new int[A.length];
        int index = 0;
        LinkedList<Integer> s = new LinkedList<>();
        for (int i =0; i <= B.length-1; i++,index++) {
            int j = 0;
            boolean found = false;
            int min = -1;
            //System.out.println("B[i] : " + B[i]);
            for (; j<= A.length-1; j++) {
                if (B[i]<A[j]) {
                    found = true;
                    break;
                }
            }
            if (found){
                // System.out.println("A[j] : " + A[j]);
                returnA[index] = A[j];
                A[j] = -1;
            } else {
                s.add(index);
            }
        }
        for (int i=0; i<=A.length-1;i++) {
            if (A[i] != -1){
                returnA[s.pollFirst()] = A[i];
            }
            if (s.size()<=0) {
                break;
            }
        }
        return returnA;
    }
}
