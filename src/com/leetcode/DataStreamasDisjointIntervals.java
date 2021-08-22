package com.leetcode;

import java.util.Objects;
import java.util.TreeSet;

/*
Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int val) Adds the integer val to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi].


Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]


Constraints:

0 <= val <= 104
At most 3 * 104 calls will be made to addNum and getIntervals.
 */
public class DataStreamasDisjointIntervals {
    TreeSet<Steam> set = null;

    /** Initialize your data structure here. */
    public DataStreamasDisjointIntervals() {
        set = new TreeSet<>();
    }

    public void addNum(int val) {
        Steam head = null, tail = null;
        for (Steam d : set) {
            if (val >=d.head && val<=d.end ) return;
            if ((d.end+1) == val) {
                head = d;
            }
            if ((d.head-1) == val) {
                tail = d;
            }
        }
        if (head != null && tail != null) {
            set.remove(tail);
            head.end = tail.end;
        } else if (head != null) {
            head.end = val;
        } else  if (tail != null) {
            tail.head = val;
        } else {
            Steam d = new Steam();
            d.setEnd(val);d.setHead(val);
            set.add(d);
        }
    }

    public int[][] getIntervals() {
        int[][] f = new int[set.size()][2];
        int i = 0;
        for (Steam s: set) {
            f[i][0] = s.head;
            f[i][1] = s.end;
            i++;
        }
        return f;
    }

    class Steam implements Comparable {
        int head;
        int end;

        public void setHead(int head) {
            this.head = head;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Steam steam = (Steam) o;
            return head == steam.head &&
                    end == steam.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(head, end);
        }

        @Override
        public int compareTo(Object o) {
            return this.head - ((Steam)o).head;
        }

        @Override
        public String toString() {
            return "[" +
                    head +
                    "," + end +
                    "]";
        }
    }
}
