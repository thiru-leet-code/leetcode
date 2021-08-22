package com.leetcode;
/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int total = 0;
        int allCnt = 0 ;
        for (int i = 0; i < nums.length; i++) {
            total = nums[i];
            allCnt += nums[i];
            if (nums[i] == k) {
                cnt++;
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (total +nums[j] == k && (i !=0 || j != nums.length-1)) {
                    cnt++;
                    //total = 0;
                    // break;
                }
                total +=nums[j];

            }
        }
        if (allCnt ==k && nums.length > 1) cnt++;
        return cnt;

        /*for (int i = 0; i < nums.length; i++) {

            if (total + nums[i] > k) {
                if (nums[i] == k) cnt++;
                total = 0;
            } else if (total +nums[i] == k) {
                total = 0;
                cnt++;
            }
            total +=nums[i];
        }
         total = 0;
        for (int i = nums.length-1; i >=0; i--) {

            if (total + nums[i] > k) {
                if (nums[i] == k) cnt++;
                total = 0;
            } else if (total +nums[i] == k) {
                total = 0;
                cnt++;
            }
            total +=nums[i];
        }*/

       // return  cnt;
    }

    public static void main(String[] args) {
        int[] d = {1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2};
        new SubarraySumEqualsK().subarraySum(d, 6);
    }
}
