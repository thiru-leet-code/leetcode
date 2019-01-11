package com.leetcode;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in
 *  the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 * @author thiru
 *
 */


public class ThreeSum {

        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, List<Integer[]>> counts = new HashMap<>();
            if (nums.length < 3) {
                return new ArrayList<>();
            }
            for (int i =0; i <= nums.length-1; i++) {
                for(int j=0; j<= nums.length-1; j++) {
                    if (i !=j) {
                        int sum = nums[i]+nums[j];
                        List<Integer[]> l = counts.get(sum);
                        if (l == null) {
                            l = new ArrayList<>();
                        }
                        Integer[] pair = new Integer[2];
                        pair[0] = i;
                        pair[1] = j;
                        l.add(pair);
                        counts.put(sum, l);
                    }
                }
            }
            Set<List<Integer>> finalList = new HashSet<>();
            for (int i =0; i <= nums.length-1; i++) {
                int key = 0-nums[i];
                List<Integer[]> pairs = counts.get(key);
                if (pairs!=null) {
                    for (Integer[] pair : pairs) {
                        List<Integer> ou = new ArrayList<>();
                        Integer[] h = new Integer[3];
                        if (i!=pair[0] && i!=pair[1]) {
                            ou.add(nums[i]);
                            ou.add(nums[pair[0]]);
                            ou.add(nums[pair[1]]);
                            Collections.sort(ou);
                            finalList.add(ou);
                            //pairs.remove(pair);
                        }
                    }

                }
            }
            return new ArrayList<>(finalList);
        }

    public List<List<Integer>> threeSumOptimal(int[] n) {
        Arrays.sort(n);
        Set<List<Integer>> finalList = new HashSet<>();
        for (int i = 0 ; i <= n.length-1; i++) {
            int j = i+1;
            int k = n.length-1;
             while (j<k) {
                 if (n[i]+n[j]+n[k] == 0) {
                     List<Integer> ou = new ArrayList<>();
                     ou.add(n[i]);
                     ou.add(n[j]);
                     ou.add(n[k]);
                     Collections.sort(ou);
                     finalList.add(ou);
                     j++;
                     k--;

                     //handle duplicate here
                     while(j<k && n[j]==n[j-1])
                         j++;
                     while(j<k && n[k]==n[k+1])
                         k--;

                 } else if (n[i]+n[j]+n[k] > 0) {
                     k--;
                 } else {
                     j++;
                 }
             }
        }
        return new ArrayList<>(finalList);
    }


        public static void main(String[] a) {
            ThreeSum S3= new ThreeSum();
            int[] f = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
            System.out.println(S3.threeSum(f));
            System.out.println("*************");
            System.out.println(S3.threeSumOptimal(f));
        }
}
