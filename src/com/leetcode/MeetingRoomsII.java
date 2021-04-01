package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/***
 * 253. Meeting Rooms II
 * Medium
 *
 * 3388
 *
 * 55
 *
 * Add to List
 *
 * Share
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        int max=1;
        sc.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (sc.peek()> intervals[i][0]) {
                sc.add(intervals[i][1]);
                max +=1;
            } else {
                sc.poll();
                sc.add(intervals[i][1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] d = {{9,10},{4,9},{4,17}};
        new MeetingRoomsII().minMeetingRooms(d);
    }
}
