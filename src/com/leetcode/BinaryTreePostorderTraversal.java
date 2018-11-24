package com.leetcode;
import java.util.*;
public class BinaryTreePostorderTraversal {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> fl = new ArrayList<>();
            traverse(root, fl);
            return fl;
        }

        void traverse(TreeNode n, List<Integer> fl) {
            if (n == null) return;
            if (n.left != null) {
                traverse(n.left, fl);
            }
            if (n.right!= null) {
                traverse(n.right, fl);
            }
            fl.add(n.val);
        }
    }
}
