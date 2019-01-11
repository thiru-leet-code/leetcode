package com.leetcode;
import java.util.*;

import com.leetcode.to.TreeNode;
public class BinaryTreeZigZagInLineTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	        boolean sl = false;
	        List<List<Integer>> fin = new ArrayList<>();
	        if (root!= null) {
	            
	            
	            Stack<TreeNode> ds = new Stack<>();
	            ds.push(root);
	            while(ds.size() > 0) {
	                    Stack<TreeNode> cs = new Stack<>();
	                List<Integer> d = new ArrayList<>();
	                while(ds.size() > 0) {
	                    TreeNode u = ds.pop();
	                    d.add(u.val);
	                    if (!sl) {
	                        if (u.left != null) cs.push(u.left);
	                        if (u.right != null) cs.push(u.right);
	                    } else {
	                        if (u.right != null) cs.push(u.right);
	                        if (u.left != null) cs.push(u.left);
	                    }
	                }
	                sl = !sl;
	                fin.add(d);
	                ds= cs;
	            }
	            
	        }
	        return fin;
	        
	    }
	}
}
