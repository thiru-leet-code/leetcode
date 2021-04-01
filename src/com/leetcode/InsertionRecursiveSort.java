package com.leetcode;


import java.util.Arrays;

public class InsertionRecursiveSort {

    public static void main(String[] args) {
        int[] values = {20,35,-15,7,55,1,-22};
        insertion(values, 1);
        Arrays.stream(values).forEach( v-> System.out.println(v)       );
    }

    private static void insertion(int[] values, int start) {
        if (start == values.length) return;
        int firstUnsorted = values[start];
        int sort;
        for (sort = start; sort >0 && firstUnsorted < values[sort -1]; sort--) {
            values[sort] = values[sort -1];
        }
        values[sort] = firstUnsorted;
        insertion(values, start+1);


    }
}
