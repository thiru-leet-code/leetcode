package com.leetcode.to;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode createTree(String str) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        String[] ints = str.split(",");
        if (ints.length == 0) return null;
        TreeNode r = new TreeNode(Integer.valueOf(ints[0].trim()));
        ll.add(r);
        int i =1;
        while(ll.size() > 0) {
            TreeNode n = ll.pollFirst();
            if (ints.length > i && !ints[i].trim().equalsIgnoreCase("null")) {
                TreeNode r1 = new TreeNode(Integer.valueOf(ints[i].trim()));
                n.left = r1;
                ll.add(r1);
            }
            i++;
            if (ints.length > i && !ints[i].trim().equalsIgnoreCase("null")) {
                TreeNode r1 = new TreeNode(Integer.valueOf(ints[i].trim()));
                n.right = r1;
                ll.add(r1);
            }
            i++;
        }
        return r;
    }

    @Override
    public String toString() {
        return ""+val;
                //+"," + left + "," + right;

    }
}
