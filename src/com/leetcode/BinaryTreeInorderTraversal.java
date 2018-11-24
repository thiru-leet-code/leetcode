package com.leetcode;
import java.util.*;
public class BinaryTreeInorderTraversal {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> fl = new ArrayList<>();
            trav(root, fl);
            return fl;
        }

        void trav(TreeNode n, List<Integer> fl) {
            if (n == null) {
                return;
            }
            if (n.left != null) {
                trav(n.left, fl);
            }
            fl.add(n.val);
            if (n.right != null) {
                trav(n.right, fl);
            }
        }

    }
}
