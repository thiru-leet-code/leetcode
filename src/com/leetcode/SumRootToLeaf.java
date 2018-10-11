package com.dictionary;

import java.util.*;

public class SumRootToLeaf {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        public int sumNumbers(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            formList(root, "", nums);
            int total =0;
            for (int i : nums) {
                total +=i;
            }
            return total;
        }

        private void formList(TreeNode node, String sb, List<Integer> nums) {
            if (node !=null) {
                if(node.left != null) {
                    formList(node.left, sb+node.val, nums);
                }
                if (node.right != null) {
                    formList(node.right, sb+node.val, nums);
                }
                if (node.left == null && node.right == null) {
                    nums.add(Integer.parseInt(sb+node.val));
                }
            }
        }
    }
}
