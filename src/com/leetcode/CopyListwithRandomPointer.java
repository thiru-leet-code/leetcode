package com.leetcode;

import java.util.*;

public class CopyListwithRandomPointer {
	
	
	  // Definition for singly-linked list with a random pointer.
	  class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
	 
	public class Solution {
	    public RandomListNode copyRandomList(RandomListNode head) {
	        Map<RandomListNode, RandomListNode> holds = new HashMap<>();
	        if (head != null) {
	            //holds.put(head, root);
	            copy(head, holds);
	            System.out.println(holds);
	        }
	        return holds.get(head);
	        
	    }
	    
	    private RandomListNode copy(RandomListNode head, Map<RandomListNode, RandomListNode> holds ) {
	        if (head == null) return null; 
	        if (holds.containsKey(head)) {
	            System.out.println("contains" + holds.get(head));
	            return holds.get(head);   
	        }
	        RandomListNode cn = holds.getOrDefault(head, new RandomListNode(head.label));
	        holds.put(head, cn);
	        //System.out.println("1 -> " + cn);
	        cn.next = head.next != null?  copy(head.next, holds) : null;
	        cn.random = head.random != null?  copy(head.random, holds) : null;
	       // System.out.println("2 -> " + cn);
	       return cn;
	        
	    }
	}
	
	public static void main(String[] a) {
		String d = "    ";
		String[] f = d.split("w");
		System.out.print(d.trim().length());
	}

}
