package com.leetcode;

public class HouseRobberII {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length <= 1) {
                return Math.max(nums[0],nums[0]);
            }
            if (nums.length <= 2) {
                return Math.max(nums[0],nums[1]);
            }
            //System.out.println("S : " + calc(nums, nums.length-1));
            return Math.max(
                    calc(nums,0, nums.length-2),
                    calc1(nums,1, nums.length-1));

        }

        int calc(int[] nums, int start, int end) {
            int a1 = 0, b=0;
            int a = nums[start];
            int b1 = nums[start+1];
            //System.out.println("end : "+ end);
            for(int i =start+2; i <= end; i++) {
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

        int calc1(int[] nums, int start, int end) {
            int a1 = 0, b=0;
            int a = nums[start];
            int b1 = nums[start+1];
            //System.out.println("end : "+ end);
            for(int i =start+2; i <= end; i++) {
                if (i%2 != 0) {
                    a1 = Math.max(nums[i]+a, nums[i]+b);
                    b = Math.max(b,b1);
                } else {
                    b1 = Math.max(nums[i]+a, nums[i]+b);
                    a = Math.max(a,a1);
                }
                //System.out.println("a - " + a + " b - " + b + " a1-" + a1 + " b1-" + b1);

            }
            return Math.max(Math.max(a,b),Math.max(a1,b1));
        }


    }
}
