package com.leetcode;

public class InOrderTraversalMinDstBST {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	    
	    int prev = -1, min = 0;
	    public int minDiffInBST(TreeNode root) {
	        min = Integer.MAX_VALUE;
	        trav(root);
	        return min;
	    }
	    
	    
	    private void trav(TreeNode node) {
	        if (node ==  null) return;
	        trav(node.left);
	        if (prev != -1) {
	            min = Math.min(min, node.val - prev);
	        }
	        prev = node.val;
	        trav(node.right);
	        
	        String a = "";
	        int u = (Integer.valueOf('1') + 1);
	    }   
	

}
