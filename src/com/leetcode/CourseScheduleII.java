package com.dictionary;

import java.util.*;

public class CourseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> dep = new HashMap<>();
            LinkedHashSet<Integer> returnA = new LinkedHashSet<>();
            int[] io = new int[numCourses];

            for (int i =0; i<= prerequisites.length-1; i++){
                List<Integer> h = dep.get(prerequisites[i][0]);
                if (h == null){
                    h = new ArrayList<>();
                    dep.put(prerequisites[i][0], h);
                }
                boolean trace = false;
            /*if (prerequisites[i][0] == 826) {
               /* dep.get(prerequisites[i][1]).stream().forEach( dsa -> {
                    System.out.println("Key : " + dsa);
                    System.out.println("Value : ");
                    if (dep.containsKey(dsa)) {
                        dep.get(dsa).stream().forEach( d -> {
                        System.out.println(" " + d);
                    });
                    }
                });
                trace= true;
            }*/
                h.add(prerequisites[i][1]);
                if (dep.containsKey(prerequisites[i][1])
                        && isCyclic(dep,prerequisites[i][1], new HashSet<Integer>(), trace)) {
                    System.out.println("Cylic dept on : " + prerequisites[i][1] + " for : " + prerequisites[i][0]);
                    return new int[0];
                }
            }
        /*dep.keySet().stream().forEach( i -> {
            System.out.println("Key : " + i);
            System.out.println("Value : ");
            dep.get(i).stream().forEach( d -> {
                System.out.println(" " + d);
            });
        });*/

            for (Integer key :dep.keySet()) {
                returnA.add(returnCource(key, dep, returnA));
            }
        /*for (int f: returnA) {
            System.out.println(f);
        }*/
            for (int y = 0; y<= numCourses-1; y++) {
                if (!returnA.contains(y)) {
                    //System.out.println("***** y " + y);
                    returnA.add(y);
                }
            }

            io = returnA.stream().mapToInt( a-> a.intValue()).toArray();
            return io;
        }

        private int returnCource(int p, Map<Integer, List<Integer>> dep, LinkedHashSet<Integer> r) {
            if (dep.containsKey(p)) {
                for (Integer u : dep.get(p)) {
                    //System.out.println("U : " + u);
                    r.add(returnCource(u, dep, r));
                }
            }
            return p;
        }

        private boolean isCyclic(Map<Integer, List<Integer>> dep, Integer key, Set<Integer> visited, boolean trace) {
        /*if (trace) {
                System.out.println("**** " + key);
            }*/
            if (dep.containsKey(key)) {
                if (visited.contains(key)) {
                    // System.out.println("$$$$$$" + key);
                    return true;
                }

                visited.add(key);
                boolean notvisited = true;
                for(Integer sd : dep.get(key)) {
                    if (visited.contains(sd)) {
                        notvisited=false;
                        // System.out.println("$$$$$$" + sd);
                        // return true;
                    }
                    if (isCyclic(dep, sd, visited, trace)) {
                        return true;
                    }
                }
                if (notvisited) {
                    visited.remove(key);
                }
            /*if(dep.get(prerequisites[i][1]).stream().findFirst().filter(a-> a==oiu).isPresent()) {
                return io;
            }*/
            }
            return false;
        }
    }
}
