package com.leetcode;
/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 20

 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int total = n*n;
        int[][] result = new int[n][n];
        int x=0, y =1;
        int i=0, j=0;
        for (int index = 1; index <= total; index++) {
            if (i >= n || j >=n || j  <0 || i < 0 || result[i][j] != 0) {
                i-=x;
                j-=y;
                if (x==0 && y==1) {
                    x =1;y=0;
                } else if (x==1 && y==0) {
                    x =0;y=-1;
                } else if (x==0 && y==-1) {
                    x =-1;y=0;
                } else {
                    x =0;y=1;
                }
                i += x;
                j+=y;
            }
            result[i][j] = index;
            i += x;
            j+=y;
        }
        return result;
    }

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }
}
