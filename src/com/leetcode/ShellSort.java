package com.leetcode;


import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] values = {20,35,-15,7,55,1,-22};

        int gap = values.length/2;
        int j = gap;
        while (gap > 1) {
            int i = j -gap;
            while ( j < values.length) {
                while (i > 0) {
                    if (values[i] < values[j]) {

                    }
                }
                j +=1;
            }
            gap /=2;
        }
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
