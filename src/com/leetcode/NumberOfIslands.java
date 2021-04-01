package com.leetcode;

/***
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[r].length; c ++) {
                if(grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c);
                }

            }
        }
        return islands;
    }

    private void dfs(char[][] g, int r, int c) {

        if (r < 0 || r > g.length-1
                || c <0 || c > g[0].length-1
                || g[r][c] == '0' || g[r][c] == '*') {
            return;
        }
        g[r][c] = '*';
        dfs(g, r-1, c);
        dfs(g, r, c-1);
        dfs(g, r, c+1);
        dfs(g, r+1, c);
    }
}
