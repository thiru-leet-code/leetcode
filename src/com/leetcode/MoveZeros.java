package com.leetcode.to;

import java.util.LinkedList;

public class MoveZeros {
    public void moveZeroesOld(int[] nums) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int n : nums) {
            if (n != 0) s.add(n);
        }
        for (int i = 0; i <= nums.length-1; i++) {
            if (s.size() > 0 ) nums[i] = s.pollFirst();
            else nums[i] =0;
        }

    }

    public void moveZeroes(int[] nums) {
        int y =0;
        for (int n : nums) {
            if (n != 0)  {
                nums[y] = n;
                y++;
            }
        }
        for (int i = y; i <= nums.length-1; i++) {
           nums[i] =0;
        }

    }
}
