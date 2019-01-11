package com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
/***
 * 
 * 
 * 53. Maximum Subarray
 * 
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 * @author thiru
 *
 */
public class MaxSubArray {

    public static void main(String[] args) {

            int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-1,-2};

            int ret = new MaxSubArray()
                    .maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], traverSum = nums[0];
        Arrays.sort(nums);
        int[] js = new int[3];
        int startIndex = 0,endIndex = 0;
        for (int i  = 0; i < nums.length;i++) {
           traverSum = Integer.max(nums[i], traverSum +nums[i]);
           if (maxSum < traverSum) {
               maxSum=traverSum;
           }
           /*else if (maxSum < (traverSum+nums[i]) && i !=0){
               traverSum += nums[i];
               if(i!= (nums.length-1))
                   startIndex = i+1;
               else
                   break;
           } else{
               maxSum = traverSum;
               endIndex = i!=0 ? i-1 : 0;
               if(i!= (nums.length-1))
               {
                   traverSum = 0;
               }
                   startIndex = i+1;

           }*/
        }
        return maxSum;
    }
}

