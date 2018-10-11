package com.dictionary;

public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0; i<= A.length-1; i++) {
            for (int j =0, z=A[i].length-1 ; j<(A[i].length)/2; j++,z--) {
                int a = A[i][j];
                A[i][j] = 1-A[i][z];
                A[i][z]= 1-a;
            }
            if (((A[i].length)%2) != 0) {
                //System.out.println("i :" + i + "j :" + (((A[i].length)/2)));
                A[i][((A[i].length)/2)] = 1- A[i][((A[i].length)/2)];
            }
        }
        int index = 1;
        index = index !=1 ? 0 : 1;

        return A;
    }
}
