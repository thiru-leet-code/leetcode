package com.leetcode;

import java.util.*;

/***
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 *
 *
 * Example 1:
 *
 *
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 *
 *
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * Example 3:
 *
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * Output: [1,4,2,5,3,8,6,9,7,10,11]
 * Example 4:
 *
 * Input: nums = [[1,2,3,4,5,6]]
 * Output: [1,2,3,4,5,6]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * There at most 10^5 elements in nums.
 */
public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,Stack<Integer>> p = new TreeMap<>();
        int tracker = 0;
        int y = 0;
        for (List<Integer> l: nums) {
            tracker++;
            y = 0;
            for (Integer i :l) {
                Stack<Integer> sc = p.getOrDefault(tracker+y, new Stack<>());
                sc.push(i);
                p.put(tracker+y, sc);
                y++;
            }
        }
        int[] f = new int[tracker+y];
        int ind = 0;
        for(int i : p.keySet()) {
            Stack<Integer> sd = p.get(i);
            while(sd.size()> 0) {
                f[ind] = sd.pop();
                ind++;
            }
        }
        return f;
    }

}
