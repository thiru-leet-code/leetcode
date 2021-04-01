package com.leetcode;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] values = {20,35,-15,7,55,1,-22};
        sort(0, values.length, values);
        Arrays.stream(values).forEach( v-> System.out.println()       );
    }

    private static void sort( int i , int j, int[] v) {
        int orgj= j;
        int orgi = i;
        if(j-i < 2) return;
        int ele = v[i];
        while (i<j) {
            while (i<j && ele< v[--j]);
            if (i<j) v[i] = v[j];
            while (i <j && ele > v[++i]);
            if (i<j) v[j] = v[i];
        }
        v[i] = ele;
        sort(orgi, i, v);
        sort(i+1, orgj, v);

    }
}
