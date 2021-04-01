package com.leetcode;

import com.leetcode.to.TreeNode;

/***
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        //return isValidBST(root,root,'c');
        boolean l = true;
        boolean r = true;
        int le = -Integer.MAX_VALUE;
        int ri = Integer.MAX_VALUE;
        if (root.left != null) {
            l = isValidBST(root.left);
            if (l && root.val > root.left.val && root.left.left!=null) {
                l &= root.val > root.left.left.val;
            }
            if (l && root.val > root.left.val && root.left.right!=null) {
                l &= root.val > root.left.right.val;
            }
            if (l && root.val > root.left.val && root.left.left!=null) {
                root.left = root.left.left;
            }
            else if (l && root.val > root.left.val && root.left.right!=null) {
                root.left = root.left.right;
            }
            le = root.left.val;
        }
        if (root.right !=  null) {
            r = isValidBST(root.right);
            if (r && root.val < root.right.val  && root.right.right!=null) {
                r &= root.val < root.right.right.val;
            }
            if (r && root.val < root.right.val  && root.right.left!=null) {
                r &= root.val < root.right.left.val;
            }
            if (r && root.val < root.right.val  && root.right.right!=null) {
                root.right = root.right.right;
            }
            else if (r && root.val < root.right.val  && root.right.left!=null) {
                root.right = root.right.left;
            }
            ri = root.right.val;
        }
        return (root.right ==  null && root.left == null) || ((root.left == null || root.val > le)
                && (root.right == null || root.val < ri)) && l && r;
    }

////////////////// COPIED ????????????

    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBSTCopied(TreeNode root) {
        return validate(root, null, null);
    }
}
