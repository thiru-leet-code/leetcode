package com.leetcode;

import com.leetcode.to.TreeNode;
/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 
 * @author thiru
 *
 */
public class TrimBinaryTree {

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
