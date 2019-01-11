package com.leetcode;
/**
 * 
 * 
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 * 
 * @author thiru
 *
 */
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
