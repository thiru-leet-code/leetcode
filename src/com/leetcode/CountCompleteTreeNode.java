package com.leetcode;

public class CountCompleteTreeNode {
	
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	class Solution {

	    public int countNodes(TreeNode root) {
	        if (root==null) return 0;
	            TreeNode le = root;
	            int lh = 0;
	        int rh = 0;
	            while (le != null) {
	                le = le.left;
	                lh++;
	            }
	            le = root;
	            while (le != null) {
	                le = le.right;
	                rh++;
	            }
	            if (lh==rh) {
	                
	                return (1 << lh)-1;
	            } else return 1+ countNodes(root.left) + countNodes(root.right);        
	    }
	}

}
