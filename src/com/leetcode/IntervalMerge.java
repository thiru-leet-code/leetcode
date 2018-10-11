package com.dictionary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class IntervalMerge {


        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            intervals.add(newInterval);
            intervals.sort(Comparator.comparing(interval ->
                interval.start));
            Stack<Interval> finalIntervals = new Stack<>();
            finalIntervals.push(intervals.get(0));
            for (Interval interval : intervals) {
                Interval topInterval = finalIntervals.peek();
                if (topInterval.start<= interval.start && topInterval.end >= interval.start) {
                    topInterval.end = Integer.max(topInterval.end,interval.end);
                } else {
                    finalIntervals.push(interval);
                }
            }
            return finalIntervals;
        }


    public static void main(String[] args) {
       List<Interval> intervals = new ArrayList<>();
       intervals.add(new Interval(1,3));
       intervals.add(new Interval(6,9));
       new IntervalMerge().insert(intervals,new Interval(2,5)).stream().forEach(interval -> {
           System.out.println("("+interval.start+","+interval.end+")");
       });

    }



}
