package com.leetcode;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;


class Solution {

    Logger log = Logger.getLogger(Solution.class.getName());
    public int findCircleNum1(int[][] M) {
        Map<Integer, Set<Integer>> friendCircle = new HashMap<>();
        IntStream.range(0, M.length).forEach(out -> {
            log.info("out >>>>>>>>>>>>> " + out);
            Map<Integer, Set<Integer>> temp = new HashMap<>();
            Set<Integer> keyREmove = new HashSet<>();
            IntStream.range(0, M[out].length).forEach(inner -> {
                if (M[out][inner] == 1) {
                    long accourance = friendCircle.values().stream().filter(
                            element -> element.contains(inner)
                                    || element.contains(out))
                            .count();
                    if (accourance == 0) {
                        friendCircle.put(Integer.max(out, inner), new HashSet<>(Arrays.asList(inner)));
                    } else {
                        friendCircle.values().stream().filter(
                                element -> element.contains(inner)
                                        || element.contains(out)).forEach(i -> {
                            i.add(inner);
                            i.add(out);
                            Set<Integer> concard = new HashSet<>(i);
                            if (friendCircle.keySet().contains(out)) concard.addAll(friendCircle.get(out));
                            if (friendCircle.keySet().contains(inner)) concard.addAll(friendCircle.get(inner));
                            temp.put(Integer.max(inner, out), concard);
                            temp.remove(Integer.min(inner, out));
                            keyREmove.add(inner);
                            keyREmove.add(out);

                        });
                        keyREmove.stream().forEach(o -> {
                            friendCircle.remove(o);
                        });
                        friendCircle.putAll(temp);

                    }
                }
            });
            friendCircle.keySet().stream().forEach(ii -> {
                log.info("key : " + ii + " Value : " + friendCircle.get(ii));
            });
        });
        return friendCircle.size();

    }

    private Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
                    //0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
        int[][] M = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0}, // 0
                     {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0}, // 1
                     {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}, // 2
                     {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0}, // 3
                     {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0}, // 4
                     {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0}, // 5
                     {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0}, // 6
                     {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0}, // 7
                     {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0}, // 8
                     {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0}, // 9
                     {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0}, // 10
                     {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0}, // 11
                     {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0}, // 12
                     {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0}, // 13
                     {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};// 12

        //int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        //int[][] M = {{1,1,0},{1,1,0},{0,0,1}};


        // int ret = new Solution().findCircleNum(M);

        int ret = new Solution().findCircleNum(M);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

    public int findCircleNum(int[][] M) {
        int fc = 0;
        for (int i =0; i <=(M.length-1); i++) {
            if (!visited.contains(i)) {
                System.out.println("********** Increamenting *****************");
                fc++;
                findFriends(i,M);
            }
        }
        return fc;

    }

    private void findFriends(int startValue, int[][] M) {
        System.out.println("adding .. " + startValue);
        visited.add(startValue);
       // IntStream.range(startValue, M.length).forEach(out -> {
            IntStream.range(0, M[startValue].length).forEach(inner -> {
                if (M[startValue][inner] == 1 && startValue!=inner && !visited.contains(inner)) {
                    findFriends(inner,M);
                    System.out.println("completing.. " + inner);
                }
            });
       // });
    }

}