package com.leetcode;

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length <= 1) {
                return Math.max(nums[0],nums[0]);
            }
            if (nums.length <= 2) {
                return Math.max(nums[0],nums[1]);
            }
            int a1 = 0, b=0;
            int a = nums[0];
            int b1 = nums[1];
            //System.out.println("end : "+ end);
            for(int i =2; i <= nums.length-1; i++) {
                if (i%2 == 0) {
                    a1 = Math.max(nums[i]+a, nums[i]+b);
                    b = Math.max(b,b1);
                } else {
                    b1 = Math.max(nums[i]+a, nums[i]+b);
                    a = Math.max(a,a1);
                }
                // System.out.println("a - " + a + " b - " + b + " a1-" + a1 + " b1-" + b1);

            }
            return Math.max(Math.max(a,b),Math.max(a1,b1));

        }

    }
}
