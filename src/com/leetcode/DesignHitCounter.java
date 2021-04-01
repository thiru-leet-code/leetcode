package com.leetcode;

import java.util.*;

/***
 * 362. Design Hit Counter
 * Medium
 *
 * 973
 *
 * 94
 *
 * Add to List
 *
 * Share
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 */
public class DesignHitCounter {

    static class HitCounter {

        NavigableMap<Integer, Integer> hit;
        /** Initialize your data structure here. */
        public HitCounter() {
            hit = new TreeMap<Integer, Integer>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            Integer l = hit.getOrDefault(timestamp, 0);
            l++;
            hit.put(timestamp, l);
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int last = -1;
            for (Integer k : hit.keySet()) {
                if (timestamp-k >= 300) {
                    last = k;
                } else break;
            }
            if (last != -1) {
                hit = hit.tailMap(last,false);
            }
            return hit.values().stream().mapToInt(Integer::intValue).sum();
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);


// get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

// get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }
}
