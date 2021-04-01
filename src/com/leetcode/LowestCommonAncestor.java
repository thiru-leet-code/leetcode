package com.leetcode;

import com.leetcode.to.TreeNode;

public class LowestCommonAncestor {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p.val, q.val);
        return ans;
    }

    public boolean find(TreeNode current, int p, int q) {
        if (current == null) {
            return false;
        }
        boolean m=false;
        if (p == current.val) m = true;
        if (q == current.val) m = true;
        boolean l = find(current.left, p, q);
        boolean r =find(current.right, p, q);
        if ((m && l) || (m && r) || (l && r)) {
            ans = current;
        }
        return m||l||r;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(7);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root,p,q).val);
    }
}
