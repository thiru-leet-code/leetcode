package com.leetcode;

import com.leetcode.to.TreeNode;

import java.util.ArrayList;
import java.util.List;

/***
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * {@link}https://leetcode.com/problems/spiral-matrix/
 */
public class SimulationSpiral {

    public List<Integer> spiralOrder(int[][] matrix) {
        int i =0, j=0;
        boolean end = false;
        int m =j, s =i, step = 1;
        char cd = 'R';
        List<Integer> l = new ArrayList<>();
        while (!end) {

            if (cd == 'R') {
                l.add(matrix[s][m]);
                matrix[s][m] = -101;
                m += step;
                if (isWall(s, m, matrix)) {
                    cd = 'D';
                    int sw = m-step;
                    step = 1;
                    m = s+step;
                    s = sw;
                    if (isWall(m, s, matrix)) {
                        end =true;
                    }
                }


            } else if (cd == 'D') {
                l.add(matrix[m][s]);
                matrix[m][s] = -101;
                m += step;
                if (isWall(m, s, matrix)) {
                    cd = 'L';
                    int sw = m-step;
                    step = -1;
                    m = s+step;
                    s = sw;
                    if (isWall(s, m, matrix)) {
                        end =true;
                    }
                }
            } else if (cd == 'L') {
                l.add(matrix[s][m]);
                matrix[s][m] = -101;
                m += step;
                if (isWall(s, m, matrix)) {
                    cd = 'U';
                    int sw = m-step;
                    step = -1;
                    m = s+step;
                    s = sw;
                    if (isWall(m, s, matrix)) {
                        end =true;
                    }
                }

            } else if (cd == 'U') {
                l.add(matrix[m][s]);
                matrix[m][s] = -101;
                m += step;
                if (isWall(m, s, matrix)) {
                    cd = 'R';
                    int sw = m-step;
                    step = 1;
                    m = s+step;
                    s = sw;
                    if (isWall(s, m, matrix)) {
                        end =true;
                    }
                }

            }
        }
        return l;
    }

    private boolean isWall(int i, int j, int[][] m) {
        return i < 0 || j < 0 || m.length-1 < i || m[0].length-1 < j || m[i][j] == -101;
    }

    public static void main(String[] args) {

        TreeNode n = TreeNode.createTree("5, 1, 4, null, null, 3, 6");
        System.out.println(n);
    }
}
