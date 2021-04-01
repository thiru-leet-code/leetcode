package com.leetcode;

import java.util.*;

public class MergeIntervals {

    /***
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     *
     * Constraints:
     *
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Stack<int[]> l = new Stack<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        if (intervals.length > 0 ) l.push(intervals[0]);
        for (int i =1; i<=intervals.length-1; i++) {
            int[] top = l.peek();
            if (intervals[i][0] >=top[0] && intervals[i][0] <= top[1]) {
                l.pop();
                top[1] = Math.max(intervals[i][1], top[1]);
            } else top = intervals[i];
            l.push(top);
        }
        return l.toArray(new int[l.size()][]);
    }

    public static void main(String[] args) {
        //int[][] d =  {{1,3},{2,6},{8,10},{15,18}};
        //int[][] d =  {{1,4},{4,5}};
        int[][] d = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        for (int[] row : new MergeIntervals().merge(d)) {
            System.out.println(Arrays.toString(row));
        }

    }
}
