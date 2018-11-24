package com.leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int ac = 0;
        int j = nums.length-1;
        for (int i=0; i<=j && j>=0; i++) {
            if (nums[i]==val) {
                while(j>=0 && nums[j]==val) {
                    j--;
                }
                if (j>i && j>=0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                }
                
            }
            ac++;
        }
        return j+1;
    }

}
