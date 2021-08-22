package com.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       /* Queue<Integer> cq = new LinkedList<>();
        for (int i =0; i < prerequisites.length;i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                    cq.add(prerequisites[i][j]);
            }
        }
        Set<Integer> sq= new HashSet<>();
        for(Integer c : cq) {
            if(sq.contains(c)) return false;
            else {
                sq.add(c);
            }
        }
        return true;*/

        Map<Integer, List<Integer>> depnsOn = new HashMap<>();
        List<Integer> allInvolvedCoures = new ArrayList<>();
        for (int i =0; i < prerequisites.length;i++) {
            if (prerequisites[i][0] == prerequisites[i][1]) return false;
            if (allInvolvedCoures.contains(prerequisites[i][0]) &&
                    allInvolvedCoures.contains(prerequisites[i][1]) &&
                    depnsOn.containsKey(prerequisites[i][1])) {
                boolean valid = traverseCheck(depnsOn,prerequisites[i][1],prerequisites[i][0]);

                if (!valid) {
                    return false;
                }
            }
            List<Integer> d = depnsOn.getOrDefault(prerequisites[i][0], new ArrayList<>());
            d.add(prerequisites[i][1]);
            depnsOn.put(prerequisites[i][0], d);
            allInvolvedCoures.add(prerequisites[i][0]);
            allInvolvedCoures.add(prerequisites[i][1]);

        }
        return true;
    }

    private boolean traverseCheck(Map<Integer, List<Integer>> depnsOn, Integer key, Integer val) {
        List<Integer> d = depnsOn.get(key);
        if (d.contains(val)) {
            return false;
        }
        AtomicBoolean b = new AtomicBoolean(true);
        d.forEach( a ->  {
            if (depnsOn.containsKey(a)) {
                b.set(b.get() && traverseCheck(depnsOn, a, val));
            }
        });
        return b.get();
    }
}
