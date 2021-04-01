package com.leetcode;


import java.util.Arrays;

public class MergeSortCourse {

    public static void main(String[] args) {
        int[] values = {20,35,-15,7,55,1,-22};
        Arrays.stream(mergeSort(values, 0, values.length-1)).forEach( v-> System.out.println(v)       );
    }

   /* private static  int[] mergesSort (int[]v, int start, int end) {
        if (start==end) {
            return new int[]{v[start]};
        }
        int mid = (end-start)/2;
        int[] first = mergesSort(v, start, start+mid-1);
        int[] second = mergesSort(v, start+mid, end);
    }*/

    private static int[] mergeSort(int[] v, int start, int end) {
        if (start==end) {
            return new int[]{v[start]};
        }
        int mid = (end-start+1)/2;
        int[] first = mergeSort(v, start, start+mid-1);
        int[] second = mergeSort(v, start+mid, end);
        int[] sorted = new int[first.length+second.length];
        int i=0, j=0;
        int z=0;
        for (; (i < first.length) && (j < second.length); z++) {
            if (first[i]<second[j]) {
                sorted[z] = first[i];
                i++;
            } else if (first[i]>second[j]) {
                sorted[z] = second[j];
                j++;
            } else {
                sorted[z++] = first[i];
                i++;
                sorted[z] = second[j];
                j++;
            }

        }
        if (i < first.length) {
            System.arraycopy(first, i, sorted, z, first.length -i);
        }
        if (j < second.length) {
            System.arraycopy(second, j, sorted, z, second.length-j);
        }
        return sorted;
    }
}
