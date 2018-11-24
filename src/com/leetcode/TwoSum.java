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
