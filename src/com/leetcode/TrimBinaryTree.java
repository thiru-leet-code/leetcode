package com.leetcode;

public class TrimBinaryTree {
    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public TreeNode trimBST(TreeNode root, int L, int R) {
            TreeNode finalTree = null;
            TreeNode left = null;
            TreeNode right = null;
            if (root!= null){
                if (root.val>= L && root.val<=R) {
                    finalTree = root;
                    finalTree.left =trimBST(root.left, L, R);
                    finalTree.right = trimBST(root.right, L, R);
                    return finalTree;

                } else {
                    left = trimBST(root.left, L, R);
                    right = trimBST(root.right, L, R);
                    if (right != null) {
                        finalTree = right;
                    } if (left!=null) {
                        if (finalTree!= null) finalTree.left = left;
                        else finalTree = left;
                    }
                }
            }
            return finalTree;
        }

}
