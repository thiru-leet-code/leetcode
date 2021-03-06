package com.leetcode;

/***
 * 
 * LeetCode 487 - Max Consecutive Ones II
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
 * 
 * @author thiru
 *
 */

public class MaxConsec1FlipOne0 {

    public int findMaxConsecutiveOnesMine(int[] nums) {
        int pre = 0;
        int post = 0;
        int last = 0;
        int zero = -1;
        int count =0;
        int maxCount =0;
        for (int i =0; i <=nums.length-1; i++) {
            if (nums[i] == 1) {
                if (zero ==-1) {
                    pre++;
                }
                if (zero==0) {
                    post++;
                }
                if (zero==1) {
                    last++;
                }
            } else {
                zero++;

                if (zero == 2) {
                    if (pre>last) {
                        count = 1+pre+post;
                    } else {
                        count = 1+post+last;
                    }
                    if (maxCount<count) {
                        maxCount = count;
                    }
                    zero=1;
                    pre = post;
                    post = last;
                    last=0;
                }
            }
        }
        if (pre != 0 && maxCount ==0) {
            if(post == 0) {
                maxCount = pre;
                if (zero>=0) {
                    maxCount++;
                }
            } else if (last == 0) {
                maxCount = 1+pre+post;
            } else if (pre>last) {
                maxCount = 1+pre+post;
            } else {
                maxCount = 1+post+last;
            }
        } else if (post != 0 && maxCount ==0) {
            maxCount = post+1;
        }else if (zero>=0 && maxCount ==0) maxCount =1;
        return maxCount;
    }
}
