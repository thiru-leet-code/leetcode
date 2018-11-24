package com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

    int[] splitSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int half = arr.length/2;
        int[] first = new int[half];
        int[] second = new int[arr.length-half];
        System.arraycopy(arr, 0, first, 0, half);
        System.arraycopy(arr, half, second, 0, arr.length);
        splitSort(first);
        splitSort(second);
        return arr;
    }

    int[] merge(int[] first, int[] second){
        int i=0,j=0,k=0;

        /*while (i<first.length && j<second.length) {
            if (i[first]<fir)
        }*/
        return first;
    }

//////////////////////////////////


public static void removeDuplicates(char[] str) {
        int tail = 0;

        int a = 1 << 'a';
    System.out.println(">>>" + Integer.toBinaryString(0 | 4 << 1));
        System.out.println("a" + a);

    a = 1 << 'a';
    System.out.println("a - " + a);


    for (int i =0 ; i < str.length; i++) {
        for (int j = i +1 ; j< str.length; j++) {
            /*if (j== (str.length-1)){
                break;
            }*/
            if (str[i] == str[j]) {
                //System.out.println("(str.length - j+2)" + (str.length-1 - j));
               // System.arraycopy(str, j+1, str, j, (str.length-1 - j));
                tail++;
                //j--;
                 str[j] = 0;
            }
        }
    }
    System.out.println(Arrays.toString(str));
    IntStream.range(0, str.length).forEach(q-> {
        System.out.print(str[q] + "-");
    });
    System.out.print("Tail " + tail);
    /*if (str == null) return;
    int len = str.length;
    if (len < 2) return;

    int tail = 1;
    for (int i = 1; i < len; ++i) {
        int j;
        for (j = 0; j < tail; ++j) {
            if (str[i] == str[j]) break;
        }
        if (j == tail) {
            str[tail] = str[i];
            ++tail;
        }
    }
    str[tail] = 0;*/
}




    //////////////////////////////

    public static void main(String[] args) {
        int[] arr = {1,7,5,8,3,89,2,3};
        String d = "bwerttyyu";
        int t = d.charAt(0);
        System.out.println("0 - " + t + " 0 - a : " + (t-'a'));

        t = d.charAt(1);
        System.out.println("1 - " + t + " 1 - a : " + (t-'a'));
        t = d.charAt(2);
        System.out.println("2 - " + t + " 2 - a : " + (t-'a'));
        t = '1';
        System.out.println("2 - " + t + " 2 - a : " + (t-'a'));
        char[] s = "aaaaassafd".toCharArray();
        (new MergeSort()).removeDuplicates(s);

    }
}