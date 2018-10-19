package com.leetcode;

public class MaxSqureArray {

    public static void main(String[] args) {

       /* char[][] nums = {{'1','0','1','0','0'},
                        {'1','0','1','1','1'},
                        {'1','1','1','1','1'},
                        {'1','0','0','1','1'}};*/

        char[][] nums = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        //int[] nums = {-1,-2};

        int ret = new MaxSqureArray()
                .maximalSquare(nums);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

    public int maximalSquare(char[][] matrix) {
        int maxArea = 0; //matrix.length > 0 ? 1 :0 ;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Character.getNumericValue(matrix[i][j]) == 1) {
                    if (maxArea ==0) maxArea =1;
                    int area = findArea(i, j, matrix);
                    if (area >maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    public int findArea(int x, int y, char[][] M) {
        int area = 1;
        for(int i =1; i < (M.length -x) && i < (M[x].length-y); i++) {
            boolean completed = false;
            for (int j = 0; j<=i;j++) {
                if (Character.getNumericValue(M[x+j][y+i]) == 0
                        || Character.getNumericValue( M[x+i][y+j]) ==0) {
                    break;

                } if (i==j && Character.getNumericValue(M[x+i][y+i]) ==1) {
                    area = ((i+1)*(i+1));
                    completed = true;
                }
            }
            if(!completed) break;

        }
        return area;
    }
}
