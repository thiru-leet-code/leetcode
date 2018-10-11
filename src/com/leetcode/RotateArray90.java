package com.dictionary;

public class RotateArray90 {
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix.length == 0){
                return;
            }
            int l = matrix.length-1;
            for (int i =0; i < matrix.length/2; i++) {
                for (int j =0; j< l-(i*2) ; j++) {
                    int temp = matrix[j+i][l-i];
                    System.out.println((j+i) + "," + (l-i));
                    matrix[j+i][l-i] = matrix[i][j+i];
                    System.out.println((l-i) + "," + (l-i-j));
                    int temp2 = matrix[l-i][l-i-j];
                    matrix[l-i][l-i-j] = temp;
                    System.out.println((l-i-j) + "," + i);
                    temp = matrix[l-i-j][i];
                    matrix[l-i-j][i] = temp2;
                    System.out.println(i + "," + (j+i));
                    matrix[i][j+i]=temp;
                }
                System.out.println("**************" + l/2);
            }

        }
    }
    public void rotate1(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        int[][] finalMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i <matrix.length; i++) {
            for (int j=0, c=matrix[i].length-1; j<=matrix[i].length-1; j++,c-- ) {
                finalMatrix[i][j]=matrix[c][i];
            }
        }
        for (int i = 0; i <matrix.length; i++) {
            for (int j=0; j<=matrix[i].length-1; j++) {
                matrix[i][j]=finalMatrix[i][j];
            }
        }

    }

    public static void main(String[] args) {
        int [][] i = {{1,2,3},{4,5,6},{7,8,9}};
        RotateArray90 r = new RotateArray90();
        Solution s = r.new Solution();
        s.rotate(i);
        for (int[] ints : i) {
            for(int j: ints) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
