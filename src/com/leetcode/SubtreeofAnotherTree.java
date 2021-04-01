package com.leetcode;

import com.leetcode.to.TreeNode;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubTree(s, t, false);
    }

    private boolean isSubTree(TreeNode s, TreeNode t, boolean found) {
        if ((s == null && t != null) || s != null && t == null) return false;
        if (s == null && t == null) return true;
        if (found) {
            if (s.val != t.val) return false;
            if ((s.left == null && t.left != null) || (s.left != null && t.left == null) || (s.right == null && t.right != null) || (s.right != null && t.right == null)) return false;
            boolean l, r;
            if (s.left!=null && t.left!=null)
                l =isSubTree(s.left, t.left, found);
            else
                l =true;
            if (s.right!=null && t.right!=null)
                r = isSubTree(s.right, t.right, found);
            else
                r = true;
            return l && r;
        }
        else {
            boolean l, r;
                l = isSubTree(s.left, t, s.val == t.val);
                r = isSubTree(s.right, t, s.val == t.val);
                return l || r;

        }
    }
}
