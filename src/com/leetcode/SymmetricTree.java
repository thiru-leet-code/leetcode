package com.leetcode;

import com.leetcode.to.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        int h = height(root);
        if (h == 1) return true;
        LinkedList<TreeNode> ll = new LinkedList<>();
        boolean result = true;
        for (int i =2; i <= h && result; i++) {
            getLevelElements(ll, root, 2, i);
            //if (ll.size() != (int) Math.pow(2, (i-1))) return false;
            if (ll.size()%2 != 0) return false;
            while (ll.size() > 0) {
                TreeNode f = ll.pollFirst();
                TreeNode l = ll.pollLast();
                result = (f == null && l == null) || ( f!= null
                        && l != null
                        && f.val == l.val);
                if (!result) break;
            }
        }
        return result;
    }

    public void getLevelElements(LinkedList<TreeNode> ll, TreeNode node, int current, int needed) {
        if (node == null) return ;
        //if (node.left == null && node.right!= null) return false;
        //if (node.left != null && node.right== null) return false;
        //if (node.left == null && node.right== null) return true;
        if (current == needed) {
            ll.add(node.left);
            ll.add(node.right);
        } else {
            getLevelElements(ll,node.left, current +1, needed);
            getLevelElements(ll, node.right, current +1 , needed);
        }

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h =0;
        int l = height(root.left);
        int r = height(root.right);
        if (l > r) {
            h = l+1;
        } else {
            h = r+1;
        }
        return h;
    }

    public static void main(String[] args) {
        for (int i =2 ; i <=4; i++) System.out.println( i + " : " + (int) Math.pow(2, (i-1)));
    }
}
