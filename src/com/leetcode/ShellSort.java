package com.leetcode;


import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] values = {20,35,-15,7,55,1,-22};
        int index = 1;
        for (index = 1; index < values.length; index++) {
            int firstUnsorted = values[index];
            int sort;
            for (sort = index; sort >0 && firstUnsorted < values[sort -1]; sort--) {
               values[sort] = values[sort -1];
            }
            values[sort] = firstUnsorted;

        }
        Arrays.stream(values).forEach( v-> System.out.println()       );
    }
}
