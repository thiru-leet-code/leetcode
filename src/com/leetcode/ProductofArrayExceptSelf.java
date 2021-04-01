package com.leetcode;

import java.util.LinkedList;

/***
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[right.length-1] = 1;
        for (int i= 1; i <= nums.length-1; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        int[] re = new int[nums.length];
        for (int i = nums.length -1; i >=0; i--) {
            if (i== nums.length - 1) re[i] = left[i];
            else {
                right[i] = right[i+1] * nums[i+1];
                re[i] = left[i] * right[i];
            }
        }
        return re;
    }

    public int[] productExceptSelfOld(int[] nums) {
        LinkedList<Holder> ll = new LinkedList();
        for (int i : nums){
            Holder h = new Holder();
            if (ll.size() == 0) {
                h.left = 1;
            } else {
                h.left = ll.peekLast().left * ll.peekLast().val;
            }
            h.val = i;
            ll.add(h);
        }
        int[] re = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                ll.get(i).right = 1;
                re[i] = ll.get(i).left * ll.get(i).right;
            } else {
                ll.get(i).right = ll.get(i +1).right* ll.get(i +1).val;
                re[i] = ll.get(i).left * ll.get(i).right;
            }
        }

        return re;
    }
    public class Holder {
        public int left;
        public int val;
        public int right;

        @Override
        public String toString() {
            return left +
                    "-" + val +
                    "-" + right;
        }
    }

    public static void main(String[] args) {
        int[] i = {2,3,4,5};
        System.out.println("[24,12,8,6] : " + new ProductofArrayExceptSelf().productExceptSelf(i));
    }
}
