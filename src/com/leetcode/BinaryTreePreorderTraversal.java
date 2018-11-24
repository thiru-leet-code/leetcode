package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        BinaryTreePostorderTraversal.TreeNode left;
        BinaryTreePostorderTraversal.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> postorderTraversal(BinaryTreePostorderTraversal.TreeNode root) {
            List<Integer> fl = new ArrayList<>();
            traverse(root, fl);
            return fl;
        }

        void traverse(BinaryTreePostorderTraversal.TreeNode n, List<Integer> fl) {
            if (n == null) return;
            fl.add(n.val);
            if (n.left != null) {
                traverse(n.left, fl);
            }
            if (n.right!= null) {
                traverse(n.right, fl);
            }
        }
    }
}
