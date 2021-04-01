package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/***
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {

        TreeMap<Double, List<int[]>> map = new TreeMap<>();
        for (int[] i : points) {
            int x = Math.abs(i[0]);
            int y = Math.abs(i[1]);
            double d = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            List<int[]> r = map.getOrDefault(d, new ArrayList<>());
            r.add(i);
            map.put(d, r);
        }
        int[][] re = new int[K][2];
        /*while (K >0) {
            double d = map.firstKey();
            for (int[] w :map.get(d)) {
                re[K-1] = w;
                K--;
                if (K==0) break;
            }
            map.remove(d);
        }*/
        for (double d : map.keySet()) {
            if (K<=0) break;
            for (int[] w :map.get(d)) {
                re[K-1] = w;
                K--;
                if (K==0) break;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[][] d = {{1,3},{-2,2}};
        System.out.println(100%60);
        for (int[] row : new KClosestPointstoOrigin().kClosest(d, 1)) {
            System.out.println(Arrays.toString(row));
        }
    }
}
