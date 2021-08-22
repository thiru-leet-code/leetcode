package com.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.leetcode.to.TreeNode;

public class BSTIterator {

    LinkedList<TreeNode> parents = null;

    public BSTIterator(TreeNode root) {
       /* if (root!= null) {
            parents = new Stack<>();
            parents.push(root);
            while(root.left!=null) {
                parents.push(root.left);
                root = root.left;
            }
        }*/
        if (root!= null) {
            parents = new LinkedList<>();
            populate(parents, root);
        }
    }

    private void populate(LinkedList<TreeNode> s, TreeNode node) {
        if (node == null) return;
        populate(s, node.left);
        s.add(node);
        populate(s, node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return parents!=null && parents.size()>0;
    }

    /** @return the next smallest number */
    public int next() {
        /*TreeNode node = parents.pop();
        int val = node.val;
        if (node.right!=null) {
            node = node.right;
            parents.push(node);
            while (node.left != null) {
                parents.push(node.left);
                node = node.left;
            }
        }

        return val;*/
        return parents.pop().val;
    }

    /**
     * ["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
     * [[[7,3,15,null,null,9,20]],[],[],[],[],[],[],[],[],[]]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree("7,3,15,null,null,9,20");
        BSTIterator bt = new BSTIterator(root);
        while(bt.hasNext()) {
            System.out.println(bt.next());
        }

    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
