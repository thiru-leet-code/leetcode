/**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


package com.leetcode;
import java.util.*;
public class TwoSum {

	    public int[] twoSumOptimal(int[] nums, int target) {
	        Map<Integer, Integer> diffHold = new HashMap<>();
	        for(int i=0; i <= nums.length-1; i++) {
	            int diff = target-nums[i];
	            if (diffHold.containsKey(nums[i])) {
	                return new int[] {diffHold.get(nums[i]), i};
	            }
	            diffHold.put(diff,i);
	        }
	        return new int[2];
	    }
	
}
