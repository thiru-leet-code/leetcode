package com.leetcode;

import java.util.Arrays;

/***
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        /*int rotationCount = k;
        int i = 0;
        int target = 0 +k;
        int max = nums.length-1;
        int pre = nums[i];
        int cur =0;
        int curstart = 0;
        while (rotationCount > 0 ) {
            while (target <= max) {
                cur = nums[target];
                nums[target] = pre;
                pre = cur;
                target += k;
            }
            rotationCount --;
            target = target -max -1;
            if (curstart == target){
                cur = nums[target];
                nums[target] = pre;
                pre = cur;
                target +=1;
                curstart = target;
            }*/

        /*
        int rotationCount = k;
        int i = 0;
        int target = 0 +k;
        int max = nums.length-1;
        int pre = nums[i];
        int cur =0;
        int curstart = 0;
        while (rotationCount > 0 ) {
            while (target <= max) {
                cur = nums[target];
                nums[target] = pre;
                pre = cur;
                target += k;
            }
            rotationCount --;
            target = target -max -1;
            if (curstart == target){
                cur = nums[target];
                nums[target] = pre;
                pre = cur;
                target +=1;
                curstart = target;
            }

        }
        //if (target<=max) nums[target] = pre;
    }
         */
        if (k == 0 ) return;
        int tracker = (k%nums.length)*2;
        int y = 1;
        while(tracker >0) {
            tracker = adjust(nums, true, nums.length-y, (k%nums.length), nums[nums.length-y], tracker, nums.length-y);
            y++;
        }
       // if (target<=max) nums[target] = pre;
    }



    private int  adjust(int[] nums, boolean start, int index, int mod, int val, int tracker, int startIndex) {

        //if (tracker==0) return tracker;
        int newIndex = index + mod;
        newIndex %= nums.length;
        if (newIndex == startIndex && !start) return tracker;
       /* if (newIndex > nums.length-1) {
            newIndex = newIndex - nums.length-;
        }*/
        int u = nums[newIndex];
        nums[newIndex] = val;
        return adjust(nums, false,newIndex, mod, u, --tracker, startIndex );
    }

    public static void main(String[] args) {
        int[] d = {1,2,3};
        new RotateArray().rotate(d,2);
        System.out.println(Arrays.toString(d));
    }
}
